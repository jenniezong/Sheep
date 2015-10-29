package jvm;

public class TestClassLoader {

	
	public interface Family{
		
	}
	
	public static class Father implements Family {
		
	}
	
	public static class Mother implements Family {
		
	}
	
	public void loader (Family family) {
		System.out.println("This is family!");
	}
	
	
	public void loader (Father father) {
		
		System.out.println("This is father!");
	}
	
	public void loader (Mother mother) {
		
		System.out.println("this is mother!");
	}
	
	public static void main (String[] args) {
		Family f = new Father();
		Family m = new Mother();
		
		TestClassLoader loader = new TestClassLoader();
		loader.loader(f);
		loader.loader(m);
	}
}



