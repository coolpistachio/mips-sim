package stages;


public class Stage_ID_EX implements IWB, IM, IEX{
	//WB
	private int regWrite;
	private int memToReg;
	//MEM
	private int memRead;
	private int memWrite;
	//EX
	private int aluSrc;
	private int regDest;
	private int aluOp;
	
	private int pc4;
	private int rd1;
	private int rd2;
	private int se;
	private int funct;
	private int shamt;
	private int rs;
	private int rt;
	private int rd;
	private int jal;
	
	private String label;
	
	public Stage_ID_EX(){
		flush();
	}

	@Override
	public int getMemToReg() {
		return this.memToReg;
	}

	@Override
	public int getRegWrite() {
		return this.regWrite;
	}

	@Override
	public void setMemToReg(int memToReg) {
		this.memToReg = memToReg;
	}

	@Override
	public void setRegWrite(int regWrite) {
		this.regWrite = regWrite;
	}

	@Override
	public int getMemRead() {
		return this.memRead;
	}

	@Override
	public int getMemWrite() {
		return this.memWrite;
	}

	@Override
	public void setMemRead(int memRead) {
		this.memRead = memRead;
	}

	@Override
	public void setMemWrite(int memWrite) {
		this.memWrite = memWrite;
	}

	@Override
	public int getAluOp() {
		return this.aluOp;
	}

	@Override
	public int getRegDest() {
		return this.regDest;
	}

	@Override
	public void setAluOp(int aluOp) {
		this.aluOp = aluOp;
	}

	@Override
	public void setRegDest(int regDest) {
		this.regDest = regDest;
	}
	
	public void setPc4(int pc4) {
		this.pc4 = pc4;
	}
	
	public int getPc4() {
		return pc4;
	}
	
	public void setRd1(int rd1) {
		this.rd1 = rd1;
	}
	
	public int getRd1() {
		return rd1;
	}
	
	public void setSe(int se) {
		this.se = se;
	}
	
	public int getSe() {
		return se;
	}
	
	public void setRt(int rt) {
		this.rt = rt;
	}
	
	public int getRt() {
		return rt;
	}
	
	public void setRd2(int rd2) {
		this.rd2 = rd2;
	}
	
	public int getRd2() {
		return rd2;
	}
	
	public void setRd(int rd) {
		this.rd = rd;
	}
	
	public int getRd() {
		return rd;
	}
	
	public void setRs(int rs) {
		this.rs = rs;
	}
	
	public int getRs() {
		return rs;
	}
	
	public void print(){
		System.out.println("-- ID/EX --");
		System.out.println("INSTRUCTION: " + getLabel());
		System.out.println("PC + 4:\t\t" + getPc4());
		System.out.println("WB:\t\t" + Integer.toBinaryString(getRegWrite()) + Integer.toBinaryString(getMemToReg()));
		System.out.println("M:\t\t" + Integer.toBinaryString(getMemRead()) + Integer.toBinaryString(getMemWrite()));
		System.out.println("EX:\t\t" + 
						   "RegDest(" + Integer.toBinaryString(getRegDest()) + ")" + 
						   "AluOp(" + Integer.toBinaryString(getAluOp()) + ")" + 
						   "AluSrc(" +Integer.toBinaryString(this.getAluSrc()) + ")");
		System.out.println("RD1:\t\t" + getRd1());
		System.out.println("RD2:\t\t" + getRd2());
		System.out.println("SE:\t\t" + getSe());
		System.out.println("RS:\t\t" + getRs());
		System.out.println("RT:\t\t" + getRt());
		System.out.println("RD:\t\t" + getRd());	
	}
	public void setAluSrc(int aluSrc) {
		this.aluSrc = aluSrc;
	}
	public int getAluSrc() {
		return aluSrc;
	}
	public void setShamt(int shamt) {
		this.shamt = shamt;
	}
	public int getShamt() {
		return shamt;
	}
	public void setJal(int jal) {
		this.jal = jal;
	}
	public int getJal() {
		return jal;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setFunct(int funct) {
		this.funct = funct;
	}

	public int getFunct() {
		return funct;
	}
	
	public String getWB(){
		return String.valueOf(this.regWrite) + "," + String.valueOf(this.memToReg);
	}
	
	public String getM(){
		return String.valueOf(this.memRead) + "," + String.valueOf(this.memWrite);		
	}

	public String getEX_0(){
		return String.valueOf(this.regDest);
	}

	public String getEX_1(){
		return Integer.toBinaryString(this.aluOp);
	}

	public String getEX_2(){
		return Integer.toBinaryString(this.aluSrc);
	}
	
	public void flush(){
		setLabel("Bubble(Nop)");
		setRegWrite(0);
		setMemToReg(0);
		setMemRead(0);
		setMemWrite(0);
		setRegDest(0);
		setAluOp(0);	
		setPc4(0);
		setRd1(0);
		setRd2(0);
		setSe(0);
		setShamt(0);
		setRs(0);
		setRt(0);
		setRd(0);
		setJal(0);
	}
}