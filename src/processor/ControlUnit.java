package processor;
public class ControlUnit {
	private int regDest;
	private int jump;
	private int branch;
	private int invZero;
	private int memRead;
	private int memToReg;
	private int aluOp;
	private int memWrite;
	private int aluSrc;
	private int regWrite;
	private int jumpR;
	private int jumpAndLink;
	
	public ControlUnit(){
		resetControlFlags();
	}
	
	public int getRegDest() {
		return regDest;
	}

	public void setRegDest(int regDest) {
		this.regDest = regDest;
	}

	public int getJump() {
		return jump;
	}

	public void setJump(int jump) {
		this.jump = jump;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public int getInvZero() {
		return invZero;
	}

	public void setInvZero(int invZero) {
		this.invZero = invZero;
	}

	public int getMemRead() {
		return memRead;
	}

	public void setMemRead(int memRead) {
		this.memRead = memRead;
	}

	public int getMemToReg() {
		return memToReg;
	}

	public void setMemToReg(int memtoReg) {
		this.memToReg = memtoReg;
	}

	public int getAluOp() {
		return aluOp;
	}

	private void setAluOp(int aluOp) {
		this.aluOp = aluOp;
	}

	public int getMemWrite() {
		return memWrite;
	}

	public void setMemWrite(int memWrite) {
		this.memWrite = memWrite;
	}

	public int getAluSrc() {
		return aluSrc;
	}

	public void setAluSrc(int aluSrc) {
		this.aluSrc = aluSrc;
	}

	public int getRegWrite() {
		return regWrite;
	}

	public void setRegWrite(int regWrite) {
		this.regWrite = regWrite;
	}

	public int getJumpR() {
		return jumpR;
	}

	public void setJumpR(int jumpR) {
		this.jumpR = jumpR;
	}

	public int getJumpAndLink() {
		return jumpAndLink;
	}

	public void setJumpAndLink(int jumpAndLink) {
		this.jumpAndLink = jumpAndLink;
	}
	
	public static String getAluCtrlBinStr(int aluOp, int funct){
		int aluCtrl = ControlUnit.getAluCtrl(aluOp, funct);
		return Integer.toBinaryString(aluCtrl) + " [" + aluCtrl + "]";
	}
	
	public void setControlFlags(int opCode){
		setControlFlags(opCode, 0);
	}
	
	public void setControlFlags(int opCode, int funct){
		resetControlFlags();
		switch(opCode){
			//R-Type [JR,ADD, SUB, AND, OR, SLT, SLL, SRL]
			case 0:
				switch(funct){
					//SLL, SRL, ADD, SUB, AND, OR, XOR, SLT
					case 0:
					case 2:
					case 32: 
					case 34:
					case 36:
					case 37:
					case 38:
					case 42://REGDEST, REGWRITE
						setRegDest(1);
						setRegWrite(1);
						break;
					//JR
					case 8://JUMPR
						setJumpR(1);
						break;
				}				
				break;
			//J
			case 2://JUMP
				setJump(1);
				break;
			//JAL
			case 3://JUMPANDLINK, REGWRITE
				setJump(1);
				setJumpAndLink(1);
				setRegWrite(1);
				break;
			//LW
			case 35://MEMREAD, REGWRITE, ALUSRC,MEMTOREG
				setMemRead(1);
				setRegWrite(1);
				setAluSrc(1);
				setMemToReg(1);				
				break;
			//SW
			case 43://MEMWRITE, ALUSRC
				setMemWrite(1);
				setAluSrc(1);
				break;
			//BEQ
			case 4://BRANCH
				setBranch(1);
				break;
			//BNE
			case 5://BRANCH, INVZERO
				setBranch(1);
				setInvZero(1);
				break;
			//ADDI, SLTI, ANDI, ORI
			case 8://REG WRITE, ALUSRC
			case 10:
			case 12:
			case 13:
				setRegWrite(1);
				setAluSrc(1);
				break;
		}
		setFlagAluOpByOC(opCode);
	}
	
	private void setFlagAluOpByOC(int opCode){
		switch(opCode){
			//R-Type [[JR] -> DON'T CARE, ADD, SUB, AND, OR, XOR, SLT]
			case 0:
				//FUNCT DEPENDS
				setAluOp(2);
				break;
			//[J,JAL] -> DON'T CARE, ANDI
			case 2:
			case 3:
			case 12:
				//AND
				setAluOp(3);
				break;
			//ADDI, LW, SW
			case 8:
			case 35:
			case 43:
				//ADD
				setAluOp(0);
				break;
			//BEQ, BNE
			case 4:
			case 5:
				//SUB
				setAluOp(1);
				break;
			//SLTI
			case 10:
				//SLT
				setAluOp(4);
				break;
			//ORI
			case 13:
				//OR
				setAluOp(5); 
				break;
		}
	}
		
	public static int getAluCtrl(int aluOp, int funct){
		switch(aluOp){
			//LW, SW
			case 0:
				//ADD
				return (2);
			//BEQ, BNE
			case 1:
				//SUB
				return(3); 	
			//R-Type [JR,ADD, SUB, AND, OR, SLT]
			case 2:
				switch(funct){
					//SLL
					case 0://SLL
						return(5);
					//SRL
					case 2://SRL
						return(4);
					//ADD
					case 32://ADD
						return(2); 	
					//SUB
					case 34://SUB
						return(3);	
					//[JR] -> DON'T CARE, AND
					case 8:
					case 36://AND
						return(0);	
					//OR
					case 37://OR
						return(1);	
					//XOR
					case 38://XOR
						return(7);
					//SLT
					case 42://SLT
						return(6);	
				}				
				break;
			//[J,JAL] -> DON'T CARE,
			case 3:
				return(0);
			//SLTI
			case 4:
				//SLT
				return(6);
			//ORI
			case 5:
				//OR
				return(1);
		}
	return 0;
	}

	private void resetControlFlags() {
		setRegDest(0);
		setJump(0);
		setBranch(0);
		setInvZero(0);
		setMemRead(0);
		setMemToReg(0);
		setAluOp(0);
		setMemWrite(0);
		setAluSrc(0);
		setRegWrite(0);
		setJumpR(0);
		setJumpAndLink(0);
	}
	
	public String getWB(){
		return String.valueOf(this.regWrite) + "," + String.valueOf(this.memToReg);
	}
	
	public String getM(){
		return String.valueOf(this.memRead) + "," + String.valueOf(this.memWrite);		
	}
	
	public String getEX(){
		return String.valueOf(this.regDest) + "," + Integer.toBinaryString(this.aluOp) + "," + Integer.toBinaryString(this.aluSrc);
	}
	
	public void printFlags(){
		System.out.println("<< Control Unit Flags >>");
		System.out.println(
				"RegDest:		\t" + getRegDest() + "\n" +
				"Jump:			\t" + getJump() + "\n" +
				"Branch:			\t" + getBranch() + "\n" + 
				"InvZero:		\t" + getInvZero() + "\n" +
				"MemRead:		\t" + getMemRead() + "\n" +
				"MemToReg:		\t" + getMemToReg() + "\n" +
				"AluOp:			\t" + getAluOp() + "\n" +
				"MemWrite:		\t" + getMemWrite() + "\n" +
				"AluSrc:			\t" + getAluSrc() + "\n" +
				"RegWrite:		\t" + getRegWrite() + "\n" +
				"JumpR:			\t" + getJumpR() + "\n" +
				"JumpAndLink:		\t" + getJumpAndLink() + "\n"
		);
	}
}
