package generic;

public class Logic {
	public static int AND(int a, int b){
		return a&b;
	}
	
	public static int NOT(int a){
		return (a == 1)? 0 : 1;
	}
	
	public static int EQUAL(int a, int b){
		return (a==b)? 1 : 0;
	}
}
