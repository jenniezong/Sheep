package designPattern.adapter;

public class AdapterObject implements Target{

	private Adaptee adaptee;
	@Override
	public void oldMethod() {
		adaptee = new Adaptee();
		adaptee.newMethod();
	}

}
