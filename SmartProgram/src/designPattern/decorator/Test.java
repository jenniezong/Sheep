package designPattern.decorator;

public class Test {

	public static void main(String[] args) {

		Sourceable source = new Source();
		Sourceable dec = new Decorator(source);
		dec.method();
	}

}
