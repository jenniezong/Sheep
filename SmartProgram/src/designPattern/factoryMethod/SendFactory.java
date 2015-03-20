package designPattern.factoryMethod;

public class SendFactory {

	/**
	 * 普通工厂方法
	 * @param type
	 * @return
	 */
	public Sender produce(String type) {
		
		
		if ("mail".equals(type)) {
			
			return new MailSender();
			
		} else if ("sms".equals(type)) {
			
			return new SmsSender();
			
		} else {
			
			System.out.println("Please input correct type!");
			return null;
		}
	}
	
	/**
	 * 多个工厂方法模式
	 * @return
	 */
	public Sender produceMail() {
		return new MailSender();
	}
	
	public Sender produceSms() {
		return new SmsSender();
	}
	
	
	/**
	 * 静态工厂方法模式
	 * @return
	 */
	public static Sender produceMail1() {
		return new MailSender();
	}
	
	public static Sender produceSms1() {
		return new SmsSender();
	}
	

}
