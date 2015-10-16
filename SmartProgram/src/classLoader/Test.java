package classLoader;

public class Test {

	public static void main(String[] args) {

		System.out.println(System.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(FileSystemClassLoader.class.getClassLoader());
		System.out.println(FileSystemClassLoader.class.getClassLoader().getParent());
		System.out.println(FileSystemClassLoader.class.getClassLoader().getParent().getParent());
		System.out.println(System.getProperty("java.class.path"));
		FileSystemClassLoader fileLoader = new FileSystemClassLoader("e:");
		try {
			fileLoader.findClass("Test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
