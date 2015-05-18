package file.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    JavaFile javaFile;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

	javaFile = new JavaFile("e:\\JavaFile.java");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateIfInfo() {

	// System.out.println("testCalculateIfInfo");
	// Stack<IfInfo> stack = new Stack<IfInfo>();
	// IfInfo ifInfo = new IfInfo(0,0);
	// stack.push(ifInfo);
	// javaFile.calculateIfInfo("if()", false);
	// assertEquals(ifInfo, javaFile.getIfStack().peek());
	//
	// javaFile.calculateIfInfo("if()", false);
	//
	// javaFile.calculateIfInfo("if ()", false);
	//
	// javaFile.calculateIfInfo("//if ()", false);
	//
	// javaFile.calculateIfInfo("/*if ()*/", false);
	//
	// javaFile.calculateIfInfo("String s = \" ifabc\"", false);
	//
	// javaFile.calculateIfInfo("String s = \"ifabc\"", false);
	//
	// javaFile.calculateIfInfo("if", false);
	//
	// javaFile.calculateIfInfo("{", false);
	//
	// javaFile.calculateIfInfo("//{", false);
	//
	// javaFile.calculateIfInfo("/*{*/", false);
	//
	// javaFile.calculateIfInfo("String s = \"{\"", false);
	// String s = " if ";
	// ;
	// String s = "abc";if(true) { return;}
	// String s = "abc"; if(true) { return;}

    }

    public void test1() {
	boolean flag = false; // if (true)
	String s = " if abc";
	String s1 = " \"if\" abc";
	char c = '"';
	int i = 0; /* intial */
	;
	int i1 = 0; // intial/;
	if (false) {
	    return;
	} /*
	   * comment
	   * 
	   * ********
	   */
	/*
	 * comment comment
	 */
    }

    @Test
    public void isStringQuote() {
	assertEquals(true, JavaFile.isDoubleQuotes(
		"String s = \" if abc\"; ".toCharArray(), 11));
	assertEquals(true, JavaFile.isDoubleQuotes(
		"String s = \" ifabc\"".toCharArray(), 18));
	assertEquals(
		false,
		JavaFile.isDoubleQuotes(
			"String s1 = \" \\\"if\\\" abc\";".toCharArray(), 15));
	assertEquals(false,
		JavaFile.isDoubleQuotes("char c = '\"';".toCharArray(), 10));
	assertEquals(true,
		JavaFile.isDoubleQuotes("\" if abc\"".toCharArray(), 0));
    }

    @Test
    public void isMultipLeComment() {
	assertEquals(
		true,
		JavaFile.isBlockComment(
			"int i = 0; /** intial */;".toCharArray(), 11));
	assertEquals(
		true,
		JavaFile.isBlockComment(
			"int i = 0; /** intial */;".toCharArray(), 22));
	assertEquals(
		false,
		JavaFile.isBlockComment(
			"int i = 0; /** intial */;".toCharArray(), 23));
    }

    @Test
    public void isSingleComment() {
	assertEquals(true, JavaFile.isToggleComment(
		"int i = 0; // intial;".toCharArray(), 11));
	assertEquals(false, JavaFile.isToggleComment(
		"int i = 0; // intial;".toCharArray(), 12));
	assertEquals(false, JavaFile.isToggleComment(
		"int i = 0; //intial/;".toCharArray(), 19));
    }

    @Test
    public void isEmptyOrCommentLine() {
	// Tab key
<<<<<<< HEAD
//	assertEquals(true, javaFile.isEmptyOrCommentLine("		"));
//	assertEquals(true, javaFile.isEmptyOrCommentLine(""));
//	assertEquals(true, javaFile.isEmptyOrCommentLine(" "));
//	assertEquals(true, javaFile.isEmptyOrCommentLine("	/*comment"));
//	assertEquals(true, javaFile.isEmptyOrCommentLine(" /*comment"));
//	assertEquals(true, javaFile.isEmptyOrCommentLine("* comment"));
//	assertEquals(true, javaFile.isEmptyOrCommentLine("*/"));
=======
	assertEquals(true, javaFile.isEmptyOrCommentLine("		"));
	assertEquals(true, javaFile.isEmptyOrCommentLine(""));
	assertEquals(true, javaFile.isEmptyOrCommentLine(" "));
	assertEquals(true, javaFile.isEmptyOrCommentLine("	/*comment"));
	assertEquals(true, javaFile.isEmptyOrCommentLine(" /*comment"));
	assertEquals(true, javaFile.isEmptyOrCommentLine("* comment"));
	assertEquals(true, javaFile.isEmptyOrCommentLine("*/"));
>>>>>>> 29358fd8f8e3be6e0b9d41f9560398b8452a1101
//	
//	assertEquals(false,
//		javaFile.isEmptyOrCommentLine("boolean flag = false;"));

    }

    @Test
    public void colIndexOfIfKey() {

//	assertEquals(1, JavaFile.colIndexOfIfKey(
//		"if(true) { return;}".toCharArray(), 0 , 1));
//	assertEquals(1, JavaFile.colIndexOfIfKey(
//		"if (true) { return;}".toCharArray(), 0, 1 ));
//	assertEquals(1, JavaFile.colIndexOfIfKey("if".toCharArray(), 0, 1));
//	assertEquals(2, JavaFile.colIndexOfIfKey(" if".toCharArray(), 0, 1));
//	// Tab key before the if
//	assertEquals(5, JavaFile.colIndexOfIfKey(
//		"	if (true) { return;}".toCharArray(), 0, 4));
//	assertEquals(18, JavaFile.colIndexOfIfKey(
//		"String s = \"abc\";if(true) { return;}".toCharArray(), 16, 17));
//	assertEquals(18, JavaFile.colIndexOfIfKey(
//		"String s = \"abc\";if (true) { return;}".toCharArray(), 16, 17));
//
//	assertEquals(
//		14,
//		JavaFile.colIndexOfIfKey(
//			"while(true) {if(true){continue;}}".toCharArray(), 13, 14));
//	assertEquals(
//		15,
//		JavaFile.colIndexOfIfKey(
//			"while(flag) {}if(false){return ;} ".toCharArray(), 14, 15));
//
//	assertEquals(-1, JavaFile.colIndexOfIfKey(
//		"String s = \" ifabc\"".toCharArray(), 12, 13));
//
//	assertEquals(-1, JavaFile.colIndexOfIfKey(
//		"public void ifKey()".toCharArray(), 11, 12));
//	assertEquals(-1,
//		JavaFile.colIndexOfIfKey("int i = 0;".toCharArray(), 3, 4));
//	assertEquals(-1,
//		JavaFile.colIndexOfIfKey("int ifa = 0;".toCharArray(), 3, 4));
    }

<<<<<<< HEAD
//    @Test
//    public void parseIfInfoForOneLine() {
//	Stack<IfInfo> stack = new Stack<IfInfo>();
//	IfInfo ifInfo = new IfInfo(0, 9,false);
//	stack.push(ifInfo);
//	javaFile.parseIfInfoForOneLine(" } else if (!stringFlag && !commentFlag && c == '}') {");
//	assertEquals(ifInfo, javaFile.getIfStack().peek());
//
//        
//    }
=======
    @Test
    public void parseIfInfoForOneLine() {
	Stack<IfInfo> stack = new Stack<IfInfo>();
	IfInfo ifInfo = new IfInfo(0, 9);
	stack.push(ifInfo);
	javaFile.parseIfInfoForOneLine(" } else if (!stringFlag && !commentFlag && c == '}') {");
	assertEquals(ifInfo, javaFile.getIfStack().peek());

        
    }
>>>>>>> 29358fd8f8e3be6e0b9d41f9560398b8452a1101

    @Test
    public void parseIfInfoForFile() {
	javaFile.findIfInfo();
	System.out.println(javaFile.getSimpleIfInfos());
	System.out.println(javaFile.getNestedIfInfos());
    }
    
//    @Test
//    public void concurrencyTest() {
//    	FindIfThread thread1 = new FindIfThread("e:\\Test1.java");
//    	thread1.start();
//    	FindIfThread thread2 = new FindIfThread("e:\\Test2.java");
//    	thread2.start();
//    	FindIfThread thread3 = new FindIfThread("e:\\Test3.java");
//    	thread3.start();
//    	FindIfThread thread4 = new FindIfThread("e:\\Test4.java");
//    	thread4.start();
//    	FindIfThread thread5 = new FindIfThread("e:\\Test5.java");
//    	thread5.start();
//    	FindIfThread thread6 = new FindIfThread("e:\\Test6.java");
//    	thread6.start();
//    	FindIfThread thread7 = new FindIfThread("e:\\Test7.java");
//    	thread7.start();
//    	FindIfThread thread8 = new FindIfThread("e:\\Test8.java");
//    	thread8.start();
//    	FindIfThread thread9 = new FindIfThread("e:\\Test9.java");
//    	thread9.start();
//    	FindIfThread thread10 = new FindIfThread("e:\\Test10.java");
//    	thread10.start();
//    }
    
    public void test() {
	// fail("Not yet implemented");
    	if(true)
       	   if(true) {
       	      return;
       	   }else if (true){} else if(true) {} else {}
    }

}
