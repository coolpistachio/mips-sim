package processor;

public class ALU {
	private int a;
	private int b;
	private int shamt;
	private int ctrl;
	private int result;
	private int zero;
	private String strOp;

	public ALU(){
		setA(0);
		setB(0);
		setShamt(0);
		setCtrl(0);
		setResult(0);
		setZero(0);
		setStrOp("");
	}
	
	public ALU(int a, int b, int ctrl){
		setA(a);
		setB(b);
		setShamt(0);
		setCtrl(ctrl);
	}
	
	public ALU(int a, int b, int shamt, int ctrl){
		setA(a);
		setB(b);
		setShamt(shamt);
		setCtrl(ctrl);
	}
	
	public void setA(int A){
		this.a=A;
	}
	
	public  int getA(){
		return this.a;	
	}
	
	public void setB(int B){
		this.b=B;
	}
	
	public int getB(){
		return this.b;
	}
	
	public void setCtrl(int ctrl) {
		this.ctrl = ctrl;
	}

	private int getCtrl() {
		return ctrl;
	}

	private void setZero(int value){
		this.zero = value;
	}
	
	public int getZero(){
		return this.zero;
	}
	
	private int AND(int a, int b){
		return a&b;
	}
	
	private int OR(int a, int b){
		return a|b;
	}
	
	private int ADD(int a, int b){
		return a+b;
	}
	
	private int SUB(int a, int b){
		return a-b;
	}
	
	private int SLT(int a, int b){
		return (a<b)? 1:0;
	}
	
	private int SRL(int a, int b){
		return a>>b;
	}
	
	private int SLL(int a, int b){
		return a<<b;
	}
	
	private int XOR(int a, int b){
		return a^b;
	}
	
	private void setResult(int result) {
		this.result = result;
		if (result == 0) setZero(1);
	}

	public int getResult() {
		return result;
	}
	
	public void setStrOp(String strOp) {
		this.strOp = strOp;
	}

	public String getStrOp() {
		return strOp;
	}

	public void setShamt(int shamt) {
		this.shamt = shamt;
	}

	public int getShamt() {
		return shamt;
	}	

	public void performOperation(){
		switch(getCtrl()){
			case 0:	setResult(AND(getA(),getB())); 
					setStrOp("AND");
					break;
			case 1:	setResult(OR(getA(),getB()));
					setStrOp("OR");
					break;
			case 2:	setResult(ADD(getA(),getB()));
					setStrOp("ADD");
					break;
			case 3:	setResult(SUB(getA(),getB()));
					setStrOp("SUB");
					break;
			case 4:	setResult(SRL(getB(),getShamt()));
					setStrOp("SRL");
					break;
			case 5:	setResult(SLL(getB(),getShamt()));
					setStrOp("SLL");
					break;
			case 6: setResult(SLT(getA(),getB()));
					setStrOp("SLT");
					break;
			case 7:	setResult(XOR(getA(), getB()));
					setStrOp("XOR");
					break;
		}
	}
}
