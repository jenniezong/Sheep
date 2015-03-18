package designPattern.adapter;

public class AdapterClass extends Adaptee implements Target{

	@Override
	public void oldMethod() {

      this.newMethod();
	}

}
