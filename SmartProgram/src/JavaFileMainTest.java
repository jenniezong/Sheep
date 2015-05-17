public class JavaFileMainTest {

	public static void main(String[] args) {

		JavaFile file = new JavaFile(args[0]);
		file.findIfInfo();
		System.out
				.println("*****************If info*****************************");
		System.out.println(file.getSimpleIfInfos());
		System.out
				.println("*****************Nested if*****************************");
		System.out.println(file.getNestedIfInfos());

	}

}
