package simulator;
import processor.Processor;
import exceptions.BinaryLengthException;

public class Simulator {
	Processor MIPS;		//Processor instance
	boolean started;
	
	public Simulator(){
	}
	
	public Processor getMIPS(){
		return this.MIPS;
	}
	
	public void standBy(Parser parser) throws BinaryLengthException{
		MIPS = new Processor(parser.getInstMem());
	}
	
	public boolean isGoingToExecute(){
		return MIPS.validPC();
	}
	
	public void nextStep(){
		setStarted(true);
		MIPS.step();
	}

	public void setStarted(boolean b) {
		this.started = b;
	}
	
	public boolean getStarted(){
		return this.started;
	}
}