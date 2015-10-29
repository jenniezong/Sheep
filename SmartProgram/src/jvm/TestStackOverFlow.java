package jvm;

public class TestStackOverFlow {

	
	public void stackOverFlow () {
		System.out.println("This is stack over flow!");
		stackOverFlow();
	}
	public static void main(String[] args) {

		TestStackOverFlow stack = new TestStackOverFlow();
		stack.stackOverFlow();
	}

}
