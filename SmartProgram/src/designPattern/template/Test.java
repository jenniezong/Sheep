package designPattern.template;

/**
 * 模板方法：一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，
 * 定义一个类，继承该抽象类，通过调用抽象类，实现对子类的调用
 * 
 * @author Administrator
 *
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

	AbstractCalculator cal1 = new Plus();
	AbstractCalculator cal2 = new Minus();
	System.out.println(cal1.calculate("2-3", "-"));
	System.out.println(cal2.calculate("2+3", "\\+"));
	
	
    }

}
