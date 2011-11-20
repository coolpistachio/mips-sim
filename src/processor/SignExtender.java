package processor;

public class SignExtender {
	private int c;
	private String extension;
	
	public SignExtender(){
		c = 0;
		extension = "";
	}
	
	public SignExtender(String sBits, int c){
		String leadingBits = "";
		setC(c);
		if (sBits.length() < 32){
			int nLeadBits = (sBits.charAt(0) == '1') ? 31 :32 ;
			nLeadBits -= sBits.length();
			for(int i=0; i<nLeadBits; i++){ leadingBits += sBits.charAt(0); }
		}
		setExtension(leadingBits + sBits);
	}

	public String getStringExtension(){
		return this.extension;
	}
	
	private void setExtension(String extension) {
		this.extension = extension;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getC() {
		return c;
	}
}
