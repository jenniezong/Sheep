package general;

public class TypeConvertTest {

    public static void main(String[] args) {

//	short ss = 99S; --> comile failed;
	short s = 99;
//	s = s+1; -> comiple failed;
	s+=1; //why ???
	
	
	//float z = 1.0; --> compile failed
	float z = 1.0f;
	//char c = 17c; --> compile failed
	
	int i = 012; 
	int j = 034;
	int k = (int)056L;
//	int l = 078; -- compile failed; 这是一个八进制；
	System.out.println("i = " +i);
	System.out.println("j = "+j);
	System.out.println("k = " +k);
	
	
	
	
	//The difference for length and length()
	String[] sArray = {"abasd","afjdla"};
	System.out.println("sArray.length " + sArray.length);
	System.out.println("sArray[1].length()" + sArray[1].length());
	int t = "fdsa".length();
	System.out.println("fdsa.length()" + t);
    }

}
