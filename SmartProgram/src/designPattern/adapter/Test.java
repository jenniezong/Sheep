package designPattern.adapter;

public class Test {

	public static void main(String[] args) {

		/**
		 * Class adapter pattern
		 */
		Target target = new AdapterClass();
		target.oldMethod();
		
		/**
		 * Object adapter pattern
		 */
		target = new AdapterObject();
		target.oldMethod();
	}

}
