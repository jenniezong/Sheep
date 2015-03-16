package designPattern.factoryMethod;

public class Test {

	public static void main(String[] args) {

		SendFactory sf = new SendFactory();
		Sender sender = sf.produce("mail");
		sender.send();
	}

}
