package generic;
public class GenericMux {
	private int a;
	private int b;
	private int c;
	private int output;
	private int ctrl;
	
	public GenericMux(){
		setA(0);
		setB(0);
		setCtrl(0);
		setOutput(0, 0, 0);
	}
	
	public GenericMux(int oA, int oB, int ctrl){
		setA(oA);
		setB(oB);
		setCtrl(ctrl);
		setOutput(oA, oB, ctrl);
	}
	
	public GenericMux(int oA, int oB, int oC, int ctrl){
		setA(oA);
		setB(oB);
		setC(oC);
		setCtrl(ctrl);
		setOutput(oA, oB, oC, ctrl);
	}
	
	private void setCtrl(int ctrl) {
		this.ctrl = ctrl;
	}

	public int getCtrl(){
		return this.ctrl;
	}
	
	private void setA(int oA) {
		this.a = oA;
	}

	private int getA(){
		return this.a;
	}

	private void setB(int oB) {
		this.b = oB;
	}

	private int getB(){
		return this.b;
	}

	public void setOutput(int oA, int oB, int ctrl){
		output = (getCtrl() == 0) ? getA() : getB();
	}
	
	public void setOutput(int oA, int oB, int oC, int ctrl){
		switch(ctrl){
			case 0: output = getA();
					break;
			case 1: output = getB();
					break;
			default: output = getC();
					 break;
		}
	}

	public int getOutput(){
		return output;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getC() {
		return c;
	}
}