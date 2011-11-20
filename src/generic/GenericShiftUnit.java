package generic;

public class GenericShiftUnit {
	private int in;
	private int out;
	
	public GenericShiftUnit(){
		setIn(0);
		setOut(0);
	}
	
	public GenericShiftUnit(int in){
		setIn(in);
		setOut(0);
	}
	
	public void shiftLeft(int shiftAmount){
		setOut( getIn() << shiftAmount);
	}
	
	private void setIn(int in){
		this.in = in;
	}
	
	public int getIn(){
		return this.in;
	}
	
	private void setOut(int out){
		this.out = out;
	}
	
	public int getOut(){
		return this.out;
	}
}