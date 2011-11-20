package processor;

import java.util.HashMap;
import generic.GenericMux;
import generic.GenericShiftUnit;
import generic.Logic;
import instructions.Instruction;
import stages.Stage_EX_MEM;
import stages.Stage_ID_EX;
import stages.Stage_IF_ID;
import stages.Stage_MEM_WB;


public class Processor {
	//Instruccion en ejecucion
	Instruction instruction;
	//Memoria de Instrucciones
	private HashMap<Integer, Instruction> im;
	//Archivo de Registros
	private RegisterFile rf;
	//Unidad de Control
	private ControlUnit cu;
	//Program Counter
	private PC pc;
	//small ALUs
	private ALU smallALU1;
	private ALU smallALU2;	
	//big ALU
	private ALU bigALU;
	//Sign Extender
	private SignExtender se;
	//Data Memory
	private DataMemory dm;
	//Muxes
	private GenericMux	muxRegDest,
						muxALUSrc,
						muxMemToReg,
						muxPCSrc,
						muxJump,
						muxWRJal,
						muxWDJal,
						muxInvZero,
						muxJr,
						muxA,
						muxB;
	//Shift Units
	private GenericShiftUnit	shiftUnit1, 
			 					shiftUnit2;	
	//Stages
	private Stage_IF_ID if_id;
	private Stage_ID_EX id_ex;
	private Stage_EX_MEM ex_mem;
	private Stage_MEM_WB mem_wb;
	//Forwarding Unit
	private FU fUnit;
	//Hazard Detection Unit
	private HDU hdUnit;
	//Prediction Branch Flag
	private int takeBranch = 0;
	
	public Processor(HashMap<Integer, Instruction> instMem){
		pc = new PC();
		im = instMem;
		cu = new ControlUnit();
		rf = new RegisterFile(32);
		dm = new DataMemory(1024);
		
		smallALU1 = new ALU();
		smallALU1 = new ALU();
		bigALU = new ALU();
		
		se = new SignExtender();
		shiftUnit1 = new GenericShiftUnit();
		shiftUnit1 = new GenericShiftUnit();

		muxRegDest = new GenericMux();
		muxALUSrc = new GenericMux();
		muxMemToReg= new GenericMux();
		muxPCSrc = new GenericMux();
		muxJump = new GenericMux();
		muxWRJal = new GenericMux();
		muxWDJal = new GenericMux();
		muxInvZero = new GenericMux();
		muxJr = new GenericMux();
		muxA = new GenericMux();
		muxB = new GenericMux();
		
		if_id = new Stage_IF_ID();
		id_ex = new Stage_ID_EX();
		ex_mem = new Stage_EX_MEM();
		mem_wb = new Stage_MEM_WB();

	}
		
	public HashMap<Integer, Instruction> getInstMemory() {
		return im;
	}
	
	public RegisterFile getRegFile() {
		return rf;
	}
	
	public PC getPC() {
		return this.pc;
	}
	
	public ALU getSmallALU1() {
		return smallALU1;
	}

	public ALU getSmallALU2() {
		return smallALU2;
	}

	public ALU getBigALU() {
		return bigALU;
	}

	public SignExtender getSE() {
		return se;
	}

	public DataMemory getDM() {
		return dm;
	}

	public ControlUnit getCU(){
		return this.cu;
	}
		
	public GenericMux getMuxJr() {
		return muxJr;
	}

	public GenericMux getMuxInvZero() {
		return muxInvZero;
	}

	public GenericMux getMuxWDJal() {
		return muxWDJal;
	}

	public GenericMux getMuxWRJal() {
		return muxWRJal;
	}

	public GenericMux getMuxJump() {
		return muxJump;
	}

	public GenericMux getMuxPCSrc() {
		return muxPCSrc;
	}

	public GenericMux getMuxMemToReg() {
		return muxMemToReg;
	}

	public GenericMux getMuxALUSrc() {
		return muxALUSrc;
	}

	public GenericMux getMuxRegDest() {
		return muxRegDest;
	}

	public GenericShiftUnit getShiftUnit2() {
		return shiftUnit2;
	}

	public GenericShiftUnit getShiftUnit1() {
		return shiftUnit1;
	}
	
	public boolean validPC(){
		if( (pc.getPC()/4) >= 0 && (pc.getPC()/4) < getInstMemory().size() && (pc.getPC()%4) == 0)
			return true;
	return false;
	}
	
	public void step(){
			setTakeBranch(0);
			
			/* STAGE 5: WRITE BACK */
			{
				//MUX WR JAL
				muxWRJal = new GenericMux(mem_wb.getRd(), 31, mem_wb.getJal());
				//REGISTER FILE
				rf.setWr(muxWRJal.getOutput());
				//MUX MEM TO REG
				muxMemToReg = new GenericMux(mem_wb.getAluResult(), mem_wb.getDataMem(), mem_wb.getMemToReg());				
				//MUX WD JAL
				muxWDJal = new GenericMux(muxMemToReg.getOutput(), mem_wb.getPc4(), mem_wb.getJal());
				//Register File Write
				rf.setWd(muxWDJal.getOutput());
				rf.write(mem_wb.getRegWrite());
			}
			
			/* STAGE 4: MEMORY */
			{
				//DATA MEMORY
				dm.setAddress(ex_mem.getAluResult());
				dm.setWd(ex_mem.getWd());
				dm.write(ex_mem.getMemWrite());
			}
			
			/* STAGE 3: INSTRUCTION EXECUTION */
			{
				//FORWARDING UNIT
				fUnit = new FU(ex_mem.getRegWrite(), 
							   ex_mem.getRd(), 
							   id_ex.getRs(), 
							   id_ex.getRt(), 
							   mem_wb.getRegWrite(), 
							   mem_wb.getRd());
				//Mux A
				muxA = new GenericMux(id_ex.getRd1(), 
									  muxMemToReg.getOutput(), 
									  ex_mem.getAluResult(), 
									  fUnit.getForwardA());
				//Mux B
				muxB = new GenericMux(id_ex.getRd2(), 
									  muxMemToReg.getOutput(), 
									  ex_mem.getAluResult(), 
									  fUnit.getForwardB());				
				//MUX ALU SRC
				muxALUSrc = new GenericMux(muxB.getOutput(), id_ex.getSe(), id_ex.getAluSrc());
				//BIG ALU
				bigALU = new ALU(muxA.getOutput(), 
								 muxALUSrc.getOutput(), 
								 id_ex.getShamt(), 
								 ControlUnit.getAluCtrl(id_ex.getAluOp(), id_ex.getFunct()));
				bigALU.performOperation();
				//MUX REG DEST
				muxRegDest = new GenericMux(id_ex.getRt(), id_ex.getRd(), id_ex.getRegDest());
			}

			/* STAGE 2: INSTRUCTION DECODE */
			{
				//CONTROL UNIT
				cu = new ControlUnit();
				cu.setControlFlags(if_id.getOpCode(), if_id.getFunct());
				//HAZARD DETECTION UNIT
				hdUnit = new HDU(id_ex.getMemRead(), id_ex.getRt(), if_id.getRs(), if_id.getRt());
				//SET PCWRITE & IF/ID WRITE
				pc.setWritable(hdUnit.getPcWrite());
				if_id.setWritable(hdUnit.getIF_ID_Write());
				//BUBBLE CONTROL FLAGS
				if(hdUnit.getCtrlMuxBubble() == 1 || if_id.isFlushed() == 1 || if_id.getLabel().equals("Bubble(Nop)")){
					cu.setRegWrite(0);
					cu.setMemRead(0);
					cu.setMemWrite(0);
				}
				//SIGN EXTENDER
				se = new SignExtender(if_id.getStrImm(), if_id.getImm());
				//SHIFT UNIT 1 JUMPS
				shiftUnit1= new GenericShiftUnit(if_id.getAddress());
				shiftUnit1.shiftLeft(2);	
				//SHIFT UNIT 2 BRANCHES
				shiftUnit2 = new GenericShiftUnit(if_id.getImm());
				shiftUnit2.shiftLeft(2);
				//2: SUM
				smallALU2 = new ALU(if_id.getPc4(), shiftUnit2.getOut(), 2);
				smallALU2.performOperation();					
				//READ REGISTER FILE
				rf.setRr1(if_id.getRs());
				rf.setRr2(if_id.getRt());
				//TAKE BRANCH?
				if ((Logic.EQUAL(rf.getRd1(), rf.getRd2()) == 1 && if_id.getOpCode() == 4) ||
					(Logic.NOT(Logic.EQUAL(rf.getRd1(), rf.getRd2())) == 1 && if_id.getOpCode() == 5) ||
					(if_id.getOpCode() == 2 || if_id.getOpCode() == 3) || (if_id.getOpCode() == 0 && if_id.getFunct() == 8)){
					setTakeBranch(1);
				}
			}
						
			/* STAGE 1: INSTRUCTION FECTH */
			{
				//2: SUM
				smallALU1 = new ALU(pc.getPC(), 4, 2);
				smallALU1.performOperation();
				//MUX INV ZERO
				muxInvZero = new GenericMux(Logic.AND(Logic.EQUAL(rf.getRd1(), rf.getRd2()), cu.getBranch()), 
											Logic.AND(Logic.NOT(Logic.EQUAL(rf.getRd1(), rf.getRd2())), cu.getBranch()),
											cu.getInvZero());
				//MUX PC SRC
				muxPCSrc = new GenericMux(smallALU1.getResult(), smallALU2.getResult(), muxInvZero.getOutput());
				//MUX JUMP
				muxJump = new GenericMux(muxPCSrc.getOutput(), shiftUnit1.getOut(), cu.getJump());
				//MUX JR
				muxJr = new GenericMux(muxJump.getOutput(), rf.getRd1(), cu.getJumpR());
				
			}
			
			if(validPC()) {
				setInstruction((Instruction) getInstMemory().get(pc.getPC()));
			} else {
				setInstruction(new Instruction());
			}
			
			//////////////////////////////////////////////////////////////////////
			{
				System.out.println("> > > > > > > > > > >");
				System.out.println("INSTRUCTION FETCH");
				System.out.println("INSTRUCTION: " + getInstruction().getLabel());
				System.out.println("ALU1:\t\t" + smallALU1.getResult());
				//getInstruction().print();
			}
			System.out.println();
			{
				System.out.println("> > > > > > > > > > >");
				System.out.println("INSTRUCTION DECODE");
				System.out.println("RS:\t\t" + rf.getRr1());
				System.out.println("RT:\t\t" + rf.getRr2());
				System.out.println("RD:\t\t" + if_id.getRd());
				System.out.println("RD1:\t\t" + rf.getRd1());
				System.out.println("RD2:\t\t" + rf.getRd2());
				System.out.println("IMM:\t\t" + se.getC());
				System.out.println("SE OUT:\t\t" + se.getStringExtension());
				System.out.println("ADDRESS:\t\t" + shiftUnit1.getIn());
				System.out.println("SL JUMP:\t\t" + shiftUnit1.getOut());
				System.out.println("SL BRANCH:\t\t" + shiftUnit2.getOut());
				System.out.println("ALU2:\t\t" + smallALU2.getResult());
			}
			if_id.print();
			{
				System.out.println("> > > > > > > > > > >");
				System.out.println("INSTRUCTION EXECUTION");
				System.out.println("A:\t\t" + bigALU.getA());
				System.out.println("B:\t\t" + bigALU.getB());
				System.out.println("BIG ALU RESULT:\t\t" + bigALU.getResult());
				System.out.println("ALU CTRL:\t\t" + ControlUnit.getAluCtrl(id_ex.getAluOp(), id_ex.getFunct()));
				System.out.println("Forwarding A:\t\t" + fUnit.getForwardA()); 
				System.out.println("Forwarding B:\t\t" + fUnit.getForwardB()); 
			}
			id_ex.print();
			ex_mem.print();
			mem_wb.print();
			
			System.out.println("* * * * * * * * * * * * * * * * * * * *\n\n\n\n\n");
			//////////////////////////////////////////////////////////////////////
			
	}

	public void nextClockEgde() {
		//NEXT PC IF WRITABLE
		if(validPC() && pc.isWritable() == 1)
			pc.setPC(muxJr.getOutput());
		
		/* New values for MEM/WB */
		mem_wb.setLabel(ex_mem.getLabel());
		//WB
		mem_wb.setRegWrite(ex_mem.getRegWrite());
		mem_wb.setMemToReg(ex_mem.getMemToReg());

		mem_wb.setPc4(ex_mem.getPc4());
		mem_wb.setJal(ex_mem.getJal());
		mem_wb.setDataMem(dm.read(ex_mem.getMemRead()));
		mem_wb.setAluResult(ex_mem.getAluResult());
		mem_wb.setRd(ex_mem.getRd());
		
		/* New values for EX/MEM*/
		ex_mem.setLabel(id_ex.getLabel());
		//WB
		ex_mem.setRegWrite(id_ex.getRegWrite());
		ex_mem.setMemToReg(id_ex.getMemToReg());
		//M
		ex_mem.setMemRead(id_ex.getMemRead());
		ex_mem.setMemWrite(id_ex.getMemWrite());
		
		ex_mem.setJal(id_ex.getJal());
		ex_mem.setPc4(id_ex.getPc4());
		ex_mem.setAluResult(bigALU.getResult());
		ex_mem.setWd(id_ex.getRd2());
		ex_mem.setRd(muxRegDest.getOutput());
				
		/* New values for ID/EX */
		id_ex.setLabel(if_id.getLabel());
		//WB
		id_ex.setRegWrite(cu.getRegWrite());
		id_ex.setMemToReg(cu.getMemToReg());
		//M
		id_ex.setMemRead(cu.getMemRead());
		id_ex.setMemWrite(cu.getMemWrite());
		//EX
		id_ex.setAluOp(cu.getAluOp());
		id_ex.setAluSrc(cu.getAluSrc());
		id_ex.setRegDest(cu.getRegDest());
		
		id_ex.setJal(cu.getJumpAndLink());
		id_ex.setPc4(if_id.getPc4());
		id_ex.setRd1(rf.getRd1());
		id_ex.setRd2(rf.getRd2());
		id_ex.setSe(se.getC());
		id_ex.setFunct(if_id.getFunct());
		id_ex.setShamt(if_id.getShamt());
		id_ex.setRs(rf.getRr1());
		id_ex.setRt(rf.getRr2());
		id_ex.setRd(if_id.getRd());

		/* New values for IF/ID */
		if(if_id.isWritable() == 1){
			if(this.takeBranch == 0){
				if_id.setFlushed(0);
				if_id.setLabel(getInstruction().getLabel());
				if_id.setPc4(smallALU1.getResult());
				if_id.setAddress(getInstruction().getIntegerCode(25, 0));
				if_id.setOpCode(getInstruction().getOpCode());
				if_id.setRs(getInstruction().getIntegerCode(25, 21));
				if_id.setRt(getInstruction().getIntegerCode(20, 16));
				if_id.setRd(getInstruction().getIntegerCode(15, 11));
				if_id.setImm(getInstruction().getIntegerCode(15, 0));
				if_id.setStrImm(getInstruction().getBinCode(15,0));
				if_id.setShamt(getInstruction().getIntegerCode(10, 6));
				if_id.setFunct(getInstruction().getIntegerCode(5, 0));
			}else
				if_id.flush();
		}else{
			id_ex.setLabel("Bubble(Nop)");
			id_ex.flush();
		}
			
	}

	private void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public Instruction getInstruction() {
		return instruction;
	}

	public void setFUnit(FU fUnit) {
		this.fUnit = fUnit;
	}

	public FU getFUnit() {
		return fUnit;
	}

	public void setMuxA(GenericMux muxA) {
		this.muxA = muxA;
	}

	public GenericMux getMuxA() {
		return muxA;
	}
	
	public void setMuxB(GenericMux muxB) {
		this.muxB = muxB;
	}

	public GenericMux getMuxB() {
		return muxB;
	}

	public void setHDUnit(HDU hDUnit) {
		hdUnit = hDUnit;
	}

	public HDU getHDUnit() {
		return hdUnit;
	}
	
	public Stage_IF_ID getIf_id() {
		return if_id;
	}

	public void setIf_id(Stage_IF_ID ifId) {
		if_id = ifId;
	}
	public Stage_ID_EX getId_ex() {
		return id_ex;
	}

	public void setId_ex(Stage_ID_EX idEx) {
		id_ex = idEx;
	}

	public Stage_EX_MEM getEx_mem() {
		return ex_mem;
	}

	public void setEx_mem(Stage_EX_MEM exMem) {
		ex_mem = exMem;
	}

	public Stage_MEM_WB getMem_wb() {
		return mem_wb;
	}

	public void setMem_wb(Stage_MEM_WB memWb) {
		mem_wb = memWb;
	}

	public void setTakeBranch(int takeBranch) {
		this.takeBranch = takeBranch;
	}
	
	public int getTakeBranch() {
		return takeBranch;
	}	
}