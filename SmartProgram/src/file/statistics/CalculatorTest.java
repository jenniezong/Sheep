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

	javaFile = new JavaFile("e:\\Test.java");
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
	assertEquals(true, JavaFile.isStringQuote(
		"String s = \" if abc\"; ".toCharArray(), 11));
	assertEquals(true, JavaFile.isStringQuote(
		"String s = \" ifabc\"".toCharArray(), 18));
	assertEquals(
		false,
		JavaFile.isStringQuote(
			"String s1 = \" \\\"if\\\" abc\";".toCharArray(), 15));
	assertEquals(false,
		JavaFile.isStringQuote("char c = '\"';".toCharArray(), 10));
	assertEquals(true,
		JavaFile.isStringQuote("\" if abc\"".toCharArray(), 0));
    }

    @Test
    public void isMultipLeComment() {
	assertEquals(
		true,
		JavaFile.isMultipLeComment(
			"int i = 0; /** intial */;".toCharArray(), 11));
	assertEquals(
		true,
		JavaFile.isMultipLeComment(
			"int i = 0; /** intial */;".toCharArray(), 22));
	assertEquals(
		false,
		JavaFile.isMultipLeComment(
			"int i = 0; /** intial */;".toCharArray(), 23));
    }

    @Test
    public void isSingleComment() {
	assertEquals(true, JavaFile.isSingleComment(
		"int i = 0; // intial;".toCharArray(), 11));
	assertEquals(false, JavaFile.isSingleComment(
		"int i = 0; // intial;".toCharArray(), 12));
	assertEquals(false, JavaFile.isSingleComment(
		"int i = 0; //intial/;".toCharArray(), 19));
    }

    @Test
    public void isEmptyOrCommentLine() {
	// Tab key
	assertEquals(true, JavaFile.isEmptyOrCommentLine("		",false));
	assertEquals(true, JavaFile.isEmptyOrCommentLine("",false));
	assertEquals(true, JavaFile.isEmptyOrCommentLine(" ",false));
	assertEquals(true, JavaFile.isEmptyOrCommentLine("	/*comment",false));
	assertEquals(true, JavaFile.isEmptyOrCommentLine(" /*comment",false));
	assertEquals(true, JavaFile.isEmptyOrCommentLine("* comment",false));
	assertEquals(true, JavaFile.isEmptyOrCommentLine("*/",false));
	assertEquals(false,
		JavaFile.isEmptyOrCommentLine("boolean flag = false;",false));

    }

    @Test
    public void colIndexOfIfKey() {

	assertEquals(1, JavaFile.colIndexOfIfKey(
		"if(true) { return;}".toCharArray(), 0 , 1));
	assertEquals(1, JavaFile.colIndexOfIfKey(
		"if (true) { return;}".toCharArray(), 0, 1 ));
	assertEquals(1, JavaFile.colIndexOfIfKey("if".toCharArray(), 0, 1));
	assertEquals(2, JavaFile.colIndexOfIfKey(" if".toCharArray(), 0, 1));
	// Tab key before the if
	assertEquals(5, JavaFile.colIndexOfIfKey(
		"	if (true) { return;}".toCharArray(), 0, 4));
	assertEquals(18, JavaFile.colIndexOfIfKey(
		"String s = \"abc\";if(true) { return;}".toCharArray(), 16, 17));
	assertEquals(18, JavaFile.colIndexOfIfKey(
		"String s = \"abc\";if (true) { return;}".toCharArray(), 16, 17));

	assertEquals(
		14,
		JavaFile.colIndexOfIfKey(
			"while(true) {if(true){continue;}}".toCharArray(), 13, 14));
	assertEquals(
		15,
		JavaFile.colIndexOfIfKey(
			"while(flag) {}if(false){return ;} ".toCharArray(), 14, 15));

	assertEquals(-1, JavaFile.colIndexOfIfKey(
		"String s = \" ifabc\"".toCharArray(), 12, 13));

	assertEquals(-1, JavaFile.colIndexOfIfKey(
		"public void ifKey()".toCharArray(), 11, 12));
	assertEquals(-1,
		JavaFile.colIndexOfIfKey("int i = 0;".toCharArray(), 3, 4));
	assertEquals(-1,
		JavaFile.colIndexOfIfKey("int ifa = 0;".toCharArray(), 3, 4));
    }

    @Test
    public void parseIfInfoForOneLine() {
	Stack<IfInfo> stack = new Stack<IfInfo>();
	IfInfo ifInfo = new IfInfo(0, 9);
	stack.push(ifInfo);
	javaFile.parseIfInfoForOneLine(" } else if (!stringFlag && !commentFlag && c == '}') {",false);
	assertEquals(ifInfo, javaFile.getIfStack().peek());

        
    }

    @Test
    public void parseIfInfoForFile() {
	javaFile.parseIfInfoForFile();
	System.out.println(javaFile.printIfInfo());
	System.out.println(javaFile.printFullIfInfo());
    }
    
    @Test
    public void isValidLeftBrace() {
	assertEquals(false,JavaFile.isValidLeftBrace("char c = '{'".toCharArray(), 10));
	assertEquals(true,JavaFile.isValidLeftBrace("char c = '{';if(true) {".toCharArray(), 22));
    }
    public void test() {
	// fail("Not yet implemented");
    }

}
