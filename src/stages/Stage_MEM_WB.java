package stages;

public class Stage_MEM_WB implements IWB{
	//WB
	private int regWrite;
	private int memToReg;
	
	private int pc4;
	private int dataMem;
	private int aluResult;
	private int rd;
	private int jal;
	private String label;
	
	public Stage_MEM_WB(){
		setLabel("Bubble(Nop)");
		setRegWrite(0);
		setMemToReg(0);
		setPc4(0);
		setDataMem(0);
		setAluResult(0);
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

	public void setDataMem(int dataMem) {
		this.dataMem = dataMem;
	}

	public int getDataMem() {
		return dataMem;
	}

	public void setAluResult(int aluResult) {
		this.aluResult = aluResult;
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
	
	public void print() {
		System.out.println("-- MEM/WB --");
		System.out.println("INSTRUCTION: " + getLabel());
		System.out.println("PC + 4:\t\t" + getPc4());
		System.out.println("WB:\t\t" + Integer.toBinaryString(getRegWrite()) + Integer.toBinaryString(getMemToReg()));
		System.out.println("DataMem:\t\t" + getDataMem());
		System.out.println("AluResult:\t\t" + getAluResult());
		System.out.println("RD:\t\t" + getRd());		
	}

	public void setPc4(int pc4) {
		this.pc4 = pc4;
	}

	public int getPc4() {
		return pc4;
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
	
	public String getWB0(){
		return String.valueOf(this.regWrite);
	}
	
	public String getWB1(){
		return String.valueOf(this.memToReg);
	}
}
