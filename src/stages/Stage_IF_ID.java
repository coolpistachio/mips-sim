package stages;

public class Stage_IF_ID {
	private int pc4;
	private int opCode;
	private int address;
	private String strImm;
	private int imm;
	private int rs;
	private int rt;
	private int rd;
	private int shamt;
	private int funct;
	private String label;
	private int writable;
	private int flushed;

	public Stage_IF_ID(){
		init();
	}
	
	public void setPc4(int pc4) {
		this.pc4 = pc4;
	}
	
	public int getPc4() {
		return this.pc4;
	}
	
	public void print(){
		System.out.println("-- IF/ID --");
		System.out.println("INSTRUCTION: " + getLabel());
		System.out.println("PC+4: " + getPc4());
		System.out.println("OpCode: " + getOpCode());
		System.out.println("Address: " + getAddress());
		System.out.println("Imm: " + getImm() );
		System.out.println("Rs: " + getRs());
		System.out.println("Rt: " + getRt());
		System.out.println("Rd: " + getRd());
		System.out.println("Shamt: " + getShamt());
		System.out.println("Funct: " + getFunct());				
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getAddress() {
		return this.address;
	}

	public void setImm(int imm) {
		this.imm = imm;
	}

	public int getImm() {
		return this.imm;
	}

	public void setRs(int rs) {
		this.rs = rs;
	}

	public int getRs() {
		return this.rs;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public int getRt() {
		return this.rt;
	}

	public void setRd(int rd) {
		this.rd = rd;
	}

	public int getRd() {
		return this.rd;
	}

	public void setShamt(int shamt) {
		this.shamt = shamt;
	}

	public int getShamt() {
		return this.shamt;
	}

	public void setFunct(int funct) {
		this.funct = funct;
	}

	public int getFunct() {
		return this.funct;
	}

	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}

	public int getOpCode() {
		return this.opCode;
	}

	public void setStrImm(String strImm) {
		this.strImm = strImm;
	}

	public String getStrImm() {
		return this.strImm;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public void setWritable(int writable) {
		this.writable = writable;
	}

	public int isWritable() {
		return this.writable;
	}

	public void init(){
		setLabel("Bubble(Nop)");
		setPc4(0);
		setOpCode(0);
		setAddress(0);
		setStrImm("0000000000000000");
		setImm(0);
		setRs(0);
		setRt(0);
		setRd(0);
		setShamt(0);
		setFunct(0);
		setWritable(1);
	}
	
	public void flush(){
		init();
		setFlushed(1);
	}

	public void setFlushed(int bubble) {
		this.flushed = bubble;
	}

	public int isFlushed() {
		return this.flushed;
	}
}