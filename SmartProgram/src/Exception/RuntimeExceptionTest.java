package Exception;

public class RuntimeExceptionTest {

	public static final void main(String[] args) {

		System.out.println("Begin!!!");

		try {
			if (true)
				throw new RuntimeException("error");
		}catch (Exception e) {
			System.out.println("error!!!");
		}
		

		System.out.println("Ending!!!");
	}
}
