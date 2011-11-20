package stages;

public class Stage_EX_MEM implements IWB, IM{
	//WB
	private int regWrite;
	private int memToReg;
	//MEM
	private int memRead;
	private int memWrite;
	
	private int pc4;
	private int aluResult;
	private int wd;
	private int rd;
	private int jal;
	
	private String label;

	public Stage_EX_MEM(){
		setLabel("Bubble(Nop)");
		setRegWrite(0);
		setMemToReg(0);
		setMemRead(0);
		setMemWrite(0);
		setPc4(0);
		setAluResult(0);
		setWd(0);
		setRd(0);
		setJal(0);
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

	public void setAluResult(int aluresult) {
		this.aluResult = aluresult;
	}

	public int getAluResult() {
		return aluResult;
	}

	public void setRd(int rd) {
		this.rd = rd;
	}

	public int getRd() {
		return rd;
	}
	
	public void print(){
		System.out.println("-- EX/MEM --");
		System.out.println("INSTRUCTION: " + getLabel());
		System.out.println("PC + 4:\t\t" + getPc4());
		System.out.println("WB:\t\t" + Integer.toBinaryString(getRegWrite()) + Integer.toBinaryString(getMemToReg()));
		System.out.println("M:\t\t" + Integer.toBinaryString(getMemRead()) + Integer.toBinaryString(getMemWrite()));
		System.out.println("ALUResult:\t\t" + getAluResult());
		System.out.println("RD:\t\t" + getRd());	
	}

	public void setPc4(int pc4) {
		this.pc4 = pc4;
	}

	public int getPc4() {
		return pc4;
	}

	public void setWd(int wd) {
		this.wd = wd;
	}

	public int getWd() {
		return wd;
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
	
	public String getWB(){
		return String.valueOf(this.regWrite) + "," + String.valueOf(this.memToReg);
	}
	
	public String getM0(){
		return String.valueOf(memRead);
	}
	
	public String getM1(){
		return String.valueOf(memWrite);		
	}
}
