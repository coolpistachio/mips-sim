package processor;
import java.util.ArrayList;

public class RegisterFile{
	private ArrayList<Integer> registerF;
	private int rr1; //Read Register 1 (rs)
	private int rr2; //Read Register 2 (rt)
	private int wr;  //Write Register
	private int wd;  //Write Data
	private int rd1; //Read Data 1
	private int rd2; //Read Data 2
	static int $ZERO = 0;
	
	public Object[] toArray(){
		return this.registerF.toArray();
	}

	public void setRr1(int rr1) {
		this.rr1 = rr1;
		setRd1(getRegisterAt(this.rr1));
	}

	public int getRr1(){
		return rr1;
	}
	
	public void setRr2(int rr2) {
		this.rr2 = rr2;
		setRd2(getRegisterAt(this.rr2));
	}

	public int getRr2(){
		return rr2;
	}

	private int getWr() {
		return wr;
	}

	public void setWr(int wr) {
		this.wr = wr;
	}


	private int getWd() {
		return wd;
	}

	public void setWd(int wd) {
		this.wd = wd;
	}

	public void write(int flagW){
		if(flagW == 1)
			setRegisterAt(getWr(), getWd());
	}
	
	public int getRd1() {
		return rd1;
	}

	private void setRd1(int rd1) {
		this.rd1 = rd1;
	}

	
	public int getRd2() {
		return rd2;
	}

	private void setRd2(int rd2) {
		this.rd2 = rd2;
	}
	
	public RegisterFile(int rSize){
		registerF = new ArrayList<Integer>(rSize);
		initFileRegister(rSize);
	}
	
	private void initFileRegister(int rSize){
		for(int i=0; i<rSize; i++)
			registerF.add(i);
	}
	
	private int getRegisterAt(int index){
		return registerF.get(index);
	}
	
	private void setRegisterAt(int index, int value){
		registerF.set(index, value);
	}
	
	public void print(){
		System.out.println(" <<< Archivo de registros >>>");
		int i=0;
		for(Integer element: registerF){
			System.out.println( (i++) + ": " + element);
		}
	}
}
