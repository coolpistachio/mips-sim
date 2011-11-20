package simulator;

import instructions.Instruction;

import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

import exceptions.BinaryLengthException;

public class Parser {
	private HashMap<Integer, Instruction> instMem;
	private int instAddress;
	
	public Parser(){
		instMem = new HashMap<Integer, Instruction>();
		instAddress = 0;
	}

	public void parse(String inst) throws BinaryLengthException {
		StringTokenizer st = new StringTokenizer(inst," ,\n\t()$");
		processCategory(inst, st.nextToken().toUpperCase(Locale.ENGLISH), st);
	}
	
	private void processCategory(String label, String name, StringTokenizer st) throws BinaryLengthException {
		if(name.equals("LW")){
			instMem.put(instAddress, categoryDataTransfer(35, label, name, st));
		}else if (name.equals("SW")){
			instMem.put(instAddress, categoryDataTransfer(43, label, name, st));
		}else if (name.equals("BEQ")){
			instMem.put(instAddress, categoryBranch(4, label, name, st));
		}else if (name.equals("BNE")){
			instMem.put(instAddress, categoryBranch(5, label, name, st));
		}else if (name.equals("ADD")){
			instMem.put(instAddress, categoryArithmeticLogical(0, label, name, st, 32));
		}else if (name.equals("SUB")){
			instMem.put(instAddress, categoryArithmeticLogical(0, label, name, st, 34));	
		}else if (name.equals("AND")){
			instMem.put(instAddress, categoryArithmeticLogical(0, label, name, st, 36));
		}else if (name.equals("OR")){
			instMem.put(instAddress, categoryArithmeticLogical(0, label, name, st, 37));
		}else if(name.equals("XOR")){
			instMem.put(instAddress, categoryArithmeticLogical(0, label, name, st, 38));
		}else if (name.equals("SLT")){
			instMem.put(instAddress, categoryArithmeticLogical(0, label, name, st, 42));
		}else if (name.equals("JR")){
			instMem.put(instAddress, categoryJumpR(0, label, name, st, 8));
		}else if (name.equals("J")){
			instMem.put(instAddress, categoryJump(2, label, name, st));
		}else if (name.equals("JAL")){
			instMem.put(instAddress, categoryJump(3, label, name, st));
		}else if (name.equals("SLL")){
			instMem.put(instAddress, categoryBitwiseShift(0, label, name, st, 0));
		}else if (name.equals("SRL")){
			instMem.put(instAddress, categoryBitwiseShift(0, label, name, st, 2));
		}else if(name.equals("ADDI")){
			instMem.put(instAddress, categoryArithmeticLogicImmediate(8, label, name, st));			
		}else if(name.equals("ANDI")){
			instMem.put(instAddress, categoryArithmeticLogicImmediate(12, label, name, st));
		}else if(name.equals("ORI")){
			instMem.put(instAddress, categoryArithmeticLogicImmediate(13, label, name, st));
		}else if(name.equals("SLTI")){
			instMem.put(instAddress, categoryArithmeticLogicImmediate(10, label, name, st));
		}
	instAddress+=4;
	}

	private Instruction categoryBitwiseShift(int opCode, String label, String name, StringTokenizer st, int funct) throws BinaryLengthException {
		Instruction inst = new Instruction();
		String binCode;
		int rd, rs=0, rt, shamt = 0;
		
		//RD
		rd = Integer.parseInt(st.nextToken());
		//RT
		rt = Integer.parseInt(st.nextToken());
		//SHAMT
		shamt = Integer.parseInt(st.nextToken());
		
		binCode = toBinaryString(opCode, 6) + toBinaryString(rs, 5) + toBinaryString(rt, 5) + toBinaryString(rd, 5) + toBinaryString(shamt, 5) + toBinaryString(funct, 6);
		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;
	}

	private Instruction categoryDataTransfer(int opCode, String label, String name, StringTokenizer st) throws BinaryLengthException {
		Instruction inst = new Instruction();
		String binCode;
		int rt, rs, immediate;
		
		//RT
		rt = Integer.parseInt(st.nextToken());		
		//IMMEDIATE
		immediate = Integer.parseInt(st.nextToken());
		//RS
		rs = Integer.parseInt(st.nextToken());
		
		binCode = toBinaryString(opCode, 6) + toBinaryString(rs, 5) + toBinaryString(rt, 5) + toBinaryString(immediate, 16);
		
		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;
	}

	private Instruction categoryBranch(int opCode, String label, String name, StringTokenizer st) throws BinaryLengthException {
		Instruction inst = new Instruction();
		String binCode;
		int rs, rt, immediate;

		//RS
		rs = Integer.parseInt(st.nextToken());
		//RT
		rt = Integer.parseInt(st.nextToken());
		//IMMEDIATE
		immediate = Integer.parseInt(st.nextToken());
		
		binCode = toBinaryString(opCode, 6) + toBinaryString(rs, 5) + toBinaryString(rt, 5) + toBinaryString(immediate, 16);

		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;
	}
	
	private Instruction categoryJump(int opCode, String label, String name, StringTokenizer st) throws BinaryLengthException {
		Instruction inst = new Instruction();
		String binCode;
		int address;

		//ADDRESS
		address = Integer.parseInt(st.nextToken());
				
		binCode = toBinaryString(opCode, 6) + toBinaryString(address, 26);
		
		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;
	}
	
	private Instruction categoryJumpR(int opCode, String label, String name, StringTokenizer st, int funct) throws BinaryLengthException {
		Instruction inst = new Instruction();
		String binCode;
		int rs;

		//RS
		rs = Integer.parseInt(st.nextToken());
				
		binCode = toBinaryString(opCode, 6) + toBinaryString(rs, 5) + toBinaryString(0, 5) + toBinaryString(0, 5) + toBinaryString(0, 5) + toBinaryString(funct, 6);
		
		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;
	}
	
	private Instruction categoryArithmeticLogicImmediate(int opCode, String label, String name, StringTokenizer st) throws BinaryLengthException{
		Instruction inst = new Instruction();
		String binCode;
		int rt, rs, immediate;
		
		//RT
		rt = Integer.parseInt(st.nextToken());
		//RS
		rs = Integer.parseInt(st.nextToken());
		//IMMEDIATE
		immediate = Integer.parseInt(st.nextToken());
		
		binCode = toBinaryString(opCode, 6) + toBinaryString(rs, 5) + toBinaryString(rt, 5) + toBinaryString(immediate, 16);
		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;		
	}
	
	private Instruction categoryArithmeticLogical(int opCode, String label, String name, StringTokenizer st, int funct) throws BinaryLengthException {
		Instruction inst = new Instruction();
		String binCode;
		int rd, rs, rt, shamt = 0;
		
		//RD
		rd = Integer.parseInt(st.nextToken());
		//RS
		rs = Integer.parseInt(st.nextToken());
		//RT
		rt = Integer.parseInt(st.nextToken());
		
		binCode = toBinaryString(opCode, 6) + toBinaryString(rs, 5) + toBinaryString(rt, 5) + toBinaryString(rd, 5) + toBinaryString(shamt, 5) + toBinaryString(funct, 6);
		inst.setOpCode(opCode);
		inst.setBinCode(binCode);
		inst.setName(name);
		inst.setLabel(label);
		return inst;
	}
	
	public HashMap<Integer, Instruction> getInstMem() {
		return instMem;
	}

	public void setInstMem(HashMap<Integer, Instruction> instMap) {
		this.instMem = instMap;
	}

	private String toBinaryString(int dec, int bitLength) throws BinaryLengthException{
		String binString;
		binString = Integer.toBinaryString(dec);
		if(binString.length() <= bitLength){
			String leadingZeros = "";
			int nZeros = bitLength - binString.length();
			for(int x=0; x<nZeros; x++) { leadingZeros  += "0"; }		
			binString = leadingZeros + binString;
		}
		else if(binString.length() > bitLength){
				if( (dec < 0 && -dec > (1<<bitLength)) || dec > 0)
					throw new BinaryLengthException("Constante "+ dec + " excede el rango de representacion: " + bitLength + " bits [-" + (1<<bitLength) + ", +" + ((1<<bitLength)-1) + "]");			
				else if( dec < 0 && bitLength == 16)	
					binString = binString.substring(16);
		}
		return binString;
	}
}