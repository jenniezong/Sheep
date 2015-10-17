package jvm.classLoader;

public class Test {

	public static void main(String[] args) {

		FileSystemClassLoader fileLoader = new FileSystemClassLoader("e:");
		try {
			fileLoader.findClass("Test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
