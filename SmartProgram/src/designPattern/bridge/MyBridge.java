package designPattern.bridge;

public class MyBridge extends Bridge{

	@Override
	public void method() {
		super.method();
		getSource().method();
	}

	
}
