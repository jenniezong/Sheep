package basic;

public class TestOverwrite {

	public static void main(String[] args) {

		Father f = new Father();
		Son s = new Son();
		f.walk();
		s.walk();
		s.run();
//		System.out.println();
	}

}
