package processor;
import java.util.ArrayList;


public class DataMemory {
	private ArrayList<Integer> memory;
	int address; //ADDRESS
	int wd;		 //WRITE DATA
	
	public DataMemory(int dSize){
		memory = new ArrayList<Integer>(dSize);
		initDataMemory(dSize);
	}
	
	public Object[] toArray(){
		return memory.toArray();
	}
	
	private void initDataMemory(int dSize){
		for(int i=0; i<dSize; i++)
			memory.add(i);
	}
	
	private int getAddress(){
		return this.address;
	}
	
	public void setAddress(int add){
		this.address = add;
	}
		
	private int getDataAt(int address){
		return memory.get(address);
	}
	
	private void setDataAt(int address, int data){
		memory.set(address, data);
	}
	
	public void setWd(int wd){
		this.wd = wd;
	}
	
	private int getWd(){
		return this.wd;
	}
	
	public void write(int flagW){
		if(flagW == 1)
			setDataAt(getAddress(), getWd());
	}
	
	public int read(int flagR){
		return (flagR == 1) ? getDataAt(getAddress()) : 0;
	}
	
	public void print(){
		System.out.println(" <<< Memoria de Datos >>>");
		int i=0;
		for(Integer element: memory){
			System.out.println( (i++) + ": " + element);
		}
	}
}
