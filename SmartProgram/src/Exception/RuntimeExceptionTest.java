package Exception;

public class RuntimeExceptionTest {

	public static final void main(String[] args) {

		System.out.println("Begin!!!");

		try {
			if (true)
				throw new RuntimeException("error");
			System.out.println("try!!!");
			return;
		}catch (Exception e) {
			System.out.println("error!!!");
			System.exit(0);
			return;
		} finally {
			System.out.println("Finally!!!");
		}
		
		

	}
}
