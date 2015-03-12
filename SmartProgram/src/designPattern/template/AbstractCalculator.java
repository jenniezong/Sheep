package designPattern.template;

public abstract class AbstractCalculator {
    
    
    public final int calculate(String exp,String opt) {
	int array[] = split(exp, opt);
	return calculate(array[0], array[1]);
    }
    
    public abstract int calculate(int num1, int num2);
    
    public int[] split(String exp,String opt) {
	String array[] = exp.split(opt);
	int[] intArray = new int[2];
	intArray[0] = Integer.valueOf(array[0]);
	intArray[1] = Integer.valueOf(array[1]);
	return intArray;
    }
    
    

}
