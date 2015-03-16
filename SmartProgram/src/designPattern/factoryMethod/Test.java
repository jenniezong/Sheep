package designPattern.factoryMethod;

public class Test {

	public static void main(String[] args) {

		SendFactory sf = new SendFactory();

		/**
		 * 普通工厂模式
		 */
		Sender sender = sf.produce("mail");
		sender.send();
	}

}
