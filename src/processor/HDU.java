package processor;

public class HDU {
	private int pcWrite;
	private int IF_ID_Write;
	private int ctrlMuxBubble;
	private int active;
	
	public HDU(int ID_EX_MemRead, 
			   int ID_EX_Rt,
			   int IF_ID_Rs,
			   int IF_ID_Rt){
	
		setPcWrite(1);
		setIF_ID_Write(1);
		setCtrlMuxBubble(0);
		setActive(0);
		
		if(ID_EX_MemRead == 1 && ((ID_EX_Rt == IF_ID_Rs) || (ID_EX_Rt == IF_ID_Rs))){
			stall_the_pipeline();
			setActive(1);
		}
	}

	private void stall_the_pipeline() {
		setPcWrite(0);
		setIF_ID_Write(0);
		setCtrlMuxBubble(1);
	}

	public void setPcWrite(int pcWrite) {
		this.pcWrite = pcWrite;
	}

	public int getPcWrite() {
		return pcWrite;
	}

	public void setCtrlMuxBubble(int ctrlMuxBubble) {
		this.ctrlMuxBubble = ctrlMuxBubble;
	}

	public int getCtrlMuxBubble() {
		return ctrlMuxBubble;
	}

	public void setIF_ID_Write(int iF_ID_Write) {
		IF_ID_Write = iF_ID_Write;
	}

	public int getIF_ID_Write() {
		return IF_ID_Write;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getActive() {
		return active;
	}
}
