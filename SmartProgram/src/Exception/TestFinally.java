package Exception;

public class TestFinally {

	public static void main(String[] args) {

		TestFinally f = new TestFinally();
		try {
			System.out.println("Hello world! Try");
			throw new Exception();
//			System.exit(0);
		} catch (Exception e) {
			System.out.println("Hello world! Exception");
			System.exit(0);
			
		}finally {
			System.out.println("Hello world! Finally");
		}
	}
	
	public static void s () {
		
	}

}
