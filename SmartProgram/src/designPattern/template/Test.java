package designPattern.template;

/**
 * ģ�巽����һ���������У���һ�����������ٶ���1...n�������������ǳ���ģ�Ҳ������ʵ�ʵķ�����
 * ����һ���࣬�̳иó����࣬ͨ�����ó����࣬ʵ�ֶ�����ĵ���
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
