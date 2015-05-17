package file.statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JavaFile {

    private List<IfInfo> ifList = new ArrayList<IfInfo>();

    private String name;

    private int rowIndex = 0;

    private int colIndex = 0;

    private boolean commentFlag = false;

    private Stack<IfInfo> ifStack = new Stack<IfInfo>();

    public JavaFile(String name) {
	this.name = name;

    }

    /**
     * 
     */
    public void parseIfInfoForFile() {

	File file = new File(name);
	String line;
	BufferedReader bf = null;

	try {
	    bf = new BufferedReader(new FileReader(file));

	    while ((line = bf.readLine()) != null) {

		rowIndex++;
		parseIfInfoForOneLine(line);

	    }

	} catch (FileNotFoundException e) {

	    e.printStackTrace();

	} catch (IOException e) {

	    e.printStackTrace();

	} finally {
	    try {
		bf.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

    }

    public void parseIfInfoForOneLine(String line) {
	char[] charArray = line.toCharArray();
	boolean stringFlag = false;

	if (isEmptyOrCommentLine(line)) {
	    return;
	}
	for (int i = 0, colIndex = 0; i < charArray.length; i++) {

	    if (charArray[i] == '\t') {
		colIndex = colIndex + 4;
	    } else {
		colIndex++;
	    }
	    if (!stringFlag && !commentFlag && isValidLeftBrace(charArray, i)) {

		if (ifStack.size() > 0) {
		    IfInfo info = ifStack.peek();
		    info.setBraceCount(info.getBraceCount() + 1);
		}

	    } else if (!stringFlag && !commentFlag
		    && isValidRightBrace(charArray, i)) {

		if (ifStack.size() > 0) {
		    IfInfo info = ifStack.peek();
		    info.setBraceCount(info.getBraceCount() - 1);
		}
		popTheClosedIf();

	    } else if (!stringFlag && !commentFlag && charArray[i] == ';') {
		popTheClosedIf();
	    } else if (!stringFlag && isSingleComment(charArray, i)) {

		break;

	    } else if (!stringFlag && isMultipLeComment(charArray, i)) {

		++i;
		commentFlag = !commentFlag;

	    } else if (isStringQuote(charArray, i)) {

		stringFlag = !stringFlag;

	    } else if (commentFlag || stringFlag) {
		continue;

	    } else if (!stringFlag) {
		int index = colIndexOfIfKey(charArray, i, colIndex);
		if (index != -1) {
		    IfInfo ifInfo = new IfInfo(rowIndex, index);
		    addToStack(ifInfo);
		}
	    }
	}
    }

    private void popTheClosedIf() {
	while (ifStack.size() > 0) {
	    IfInfo info = ifStack.peek();
	    if (info.getBraceCount() == 0) {
		ifList.add(ifStack.pop());
	    }else {
		break;
	    }
	}
    }

    public static boolean isValidLeftBrace(char[] charArray, int i) {

	boolean result = false;
	if (i >= 1) {
	    result = (charArray[i - 1] != '\'' && charArray[i] == '{');
	}

	return result;
    }

    public static boolean isValidRightBrace(char[] charArray, int i) {

	boolean result = false;
	if (i >= 1) {
	    result = (charArray[i - 1] != '\'' && charArray[i] == '}');
	}

	return result;
    }

    /**
     * 
     * @param charArray
     * @param i
     * @return
     */
    public static boolean isMultipLeComment(char[] charArray, int i) {
	boolean result = false;
	result = (charArray[i] == '/' && i + 1 <= charArray.length - 1 && charArray[i + 1] == '*')
		|| (charArray[i] == '*' && i + 1 <= charArray.length - 1 && charArray[i + 1] == '/');
	return result;
    }

    /**
     * 
     * @param charArray
     * @param i
     * @return
     */
    public static boolean isSingleComment(char[] charArray, int i) {
	boolean result = false;
	result = (charArray[i] == '/' && i + 1 <= charArray.length - 1 && charArray[i + 1] == '/');

	return result;
    }

    public static boolean isStringQuote(char[] charArray, int i) {
	boolean result = false;

	if (i > 0) {
	    result = (charArray[i] == '"' && (charArray[i - 1] != '\'' && charArray[i - 1] != '\\'));
	} else {
	    result = (charArray[i] == '"');
	}

	return result;

    }

    /**
     * Get the column index for if key in the specified string
     * 
     * @param line
     *            the specified string
     * @param i
     *            the index of the string
     * @return -1 if there doesn't contain the if key
     */
    public static int colIndexOfIfKey(char[] charArray, int i, int colIndex) {

	int index = -1;
	int j = 0;

	if (charArray[i] == ' ' || charArray[i] == ';' || charArray[i] == '\t') {
	    j = i + 1;
	    if (isContainIf(charArray, j)) {
		index = colIndex + 1;
	    }
	} else if (i == 0 || charArray[i - 1] == '{' || charArray[i - 1] == '}') {
	    j = i;
	    if (isContainIf(charArray, j)) {
		index = colIndex;
	    }
	}
	return index;
    }

    /**
     * 
     * @param charArray
     * @param i
     * @return
     */
    private static boolean isContainIf(char[] charArray, int i) {
	boolean result = false;
	if (i + 1 <= charArray.length - 1
		&& charArray[i] == 'i'
		&& charArray[i + 1] == 'f'
		&& ((i + 2 <= charArray.length - 1 && (charArray[i + 2] == ' ' || charArray[i + 2] == '(')) || i + 1 == charArray.length - 1)) {
	    result = true;
	}

	return result;
    }

    private void addToStack(IfInfo ifInfo) {

	if (ifStack.size() > 0) {
	    ifStack.peek().addChildren(ifInfo);
	    ifInfo.setDepth(ifStack.peek().getDepth() + 1);
	}
	ifStack.push(ifInfo);
    }

    public boolean isEmptyOrCommentLine(String line) {
	boolean result = false;

	if (line.trim().equals("") || line.trim().startsWith("//")
		|| line.trim().startsWith("/*") || line.trim().startsWith("*")
		|| line.trim().endsWith("*/") || commentFlag) {

	    if (line.trim().startsWith("/*") || line.trim().endsWith("*/")) {
		commentFlag = !commentFlag;
	    }
	    result = true;
	}
	return result;
    }

    public Stack<IfInfo> getIfStack() {
	return ifStack;
    }

    public void setIfStack(Stack<IfInfo> ifStack) {
	this.ifStack = ifStack;
    }

    public String printIfInfo() {
	StringBuilder sb = new StringBuilder();
	sb.append("totally:");
	sb.append(ifList.size());
	sb.append(" positions:");
	for (IfInfo ifInfo : ifList) {
	    sb.append(ifInfo.toString());
	}

	return sb.toString();
    }

    public String printFullIfInfo() {
	StringBuilder sb = new StringBuilder();
	sb.append("totally:");
	sb.append(ifList.size() + "\n");
	for (IfInfo ifInfo : ifList) {
	    sb.append("[position:");
	    sb.append(ifInfo.toString());
	    sb.append(" depth:");
	    sb.append(ifInfo.getDepth() + "]\n");
	}

	return sb.toString();
    }
}
