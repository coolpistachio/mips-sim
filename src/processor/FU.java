package processor;

public class FU {
	private int forwardA;
	private int forwardB;
	private int active;
	
	public FU(int EX_MEM_RegWrite,
			  int EX_MEM_Rd,
			  int ID_EX_Rs,
			  int ID_EX_Rt,
			  int MEM_WB_RegWrite,
			  int MEM_WB_Rd){
		
		setForwardA(0);
		setForwardB(0);
		setActive(0);
		
		/* EX Hazard */
		//Take A from the prior ALU result
		if(EX_MEM_RegWrite == 1 && EX_MEM_Rd != 0 && (EX_MEM_Rd == ID_EX_Rs))
			setForwardA(2);

		//Take B from the prior ALU result
		if(EX_MEM_RegWrite == 1 && EX_MEM_Rd != 0 && (EX_MEM_Rd == ID_EX_Rt))
			setForwardB(2);
		/* END EX Hazard */
		
		/* MEM Hazard */
		//Take A from data memory or an earlier ALU result
		if(MEM_WB_RegWrite == 1 && MEM_WB_Rd != 0 && (EX_MEM_Rd != ID_EX_Rs) && (MEM_WB_Rd == ID_EX_Rs))
			setForwardA(1);
		
		//Take B from data memory or an earlier ALU result
		if(MEM_WB_RegWrite == 1 && MEM_WB_Rd != 0 && (EX_MEM_Rd != ID_EX_Rt) && (MEM_WB_Rd == ID_EX_Rt))
			setForwardB(1);
		/*END MEM Hazard */	
	}
	
	public int getForwardA() {
		return forwardA;
	}
	
	public void setForwardA(int forwardA) {
		if(forwardA != 0)
			setActive(1);
		this.forwardA = forwardA;
	}
	
	public int getForwardB() {
		return forwardB;
	}
	
	public void setForwardB(int forwardB) {
		if(forwardB != 0)
			setActive(1);
		this.forwardB = forwardB;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getActive() {
		return active;
	}
}
