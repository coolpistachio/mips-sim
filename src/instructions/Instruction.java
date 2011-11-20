package instructions;

public class Instruction {
	private String label;		//Instruction label
	private String name;		//Instruction Name
	private String binCode;	    //Binary Code
	private long numCode;		//Numeric Code
	private int type;			//Type of Instruction
	private int opCode;		    //6 bits

	public Instruction(){
		setName("Bubble(Nop)");
		setLabel("Bubble(Nop)");
		setBinCode(new String("00000000000000000000000000000000"));
		setNumCode(0);
		setType(0);
		setOpCode(0);
	}
	
	public void setName(String label) {
		this.name = label;
	}

	public String getName() {
		return name;
	}

	public String getBinCode() {
		return binCode;
	}

	public int getIntegerCode(int endBit, int startBit){
		String binCode;
		int intConv = 0;
		binCode = getBinCode32Bits(endBit, startBit);
		
		if(binCode.charAt(0) == '1'){
			binCode = binCode.substring(1); 
			intConv = Integer.parseInt(binCode,2);
			intConv = ~intConv;
			intConv &= 0X7FFFFFFF;
			intConv = -(++intConv);
		}else
			intConv = Integer.parseInt(binCode,2);
		return intConv;
	}
	
	public String getBinCode(int endBit, int startBit){
		return (getBinCode().substring( getPosBit(endBit), getPosBit(startBit)+1));
	}
	
	public String getBinCode32Bits(int endBit, int startBit){
		String bCode = getBinCode(endBit, startBit);		
		int nLeadingBits = 32 - bCode.length();
		String leadingBits = "";
		
		//IMMEDIATE(16) OR ADDRESS(26), Check if they are negative
		if((bCode.length() == 16 || bCode.length() == 26) && bCode.charAt(0) == '1'){			
			for(int i=0; i<nLeadingBits; i++){ leadingBits += "1"; }
			bCode = leadingBits + bCode;
		}else{
			for(int i=0; i<nLeadingBits; i++){ leadingBits += "0"; }
			bCode = leadingBits + bCode;
		}
		return bCode;
	}

	public String getBinCodeAndInteger(int endBit, int startBit){
		String binCode;
		int intConv;
		binCode = getBinCode(endBit, startBit);
		intConv = getIntegerCode(endBit, startBit);
		return (binCode + " [" + intConv + "]");
	}
	
	public void setBinCode(String binCode) {
		this.binCode = binCode;
		setNumCode(Long.parseLong(binCode, 2));
	}

	public int getPosBit(int index){
		return ((getBinCode().length() - 1) - index);
	}
	
	public void setType(int t){
		type = t;
	}
	
	public int getType(){
		return type;
	}
	
	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}

	public int getOpCode() {
		return opCode;
	}
		
	public void print(){
		System.out.print(
					"Label: " + getLabel() + "\n" +
					"BinCode: " + getBinCode() + "\n" 
		);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setNumCode(long numCode) {
		this.numCode = numCode;
	}

	public long getNumCode() {
		return numCode;
	}
}
