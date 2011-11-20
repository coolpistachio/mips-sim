package processor;

public class PC {
	private int pc;
	private int writable;
	
	public PC(){
		pc = 0;
	}
	
	public void setPC(int pc){
		this.pc = pc;
	}
	
	public int getPC(){
		return this.pc;
	}

	public void setWritable(int writable) {
		this.writable = writable;
	}

	public int isWritable() {
		return writable;
	}
}
