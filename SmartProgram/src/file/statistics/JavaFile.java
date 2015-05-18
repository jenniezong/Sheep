package file.statistics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class JavaFile {

	private List<IfInfo> ifList = new ArrayList<IfInfo>();

	private String name;

	private int rowIndex = 0;

	private int columnIndex = 0;

	private boolean commentFlag = false;

	private Stack<IfInfo> ifStack = new Stack<IfInfo>();

	public JavaFile(String name) {
		this.name = name;

	}

	public void findIfInfo() {

		File file = new File(name);
		String line;
		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader(file));

			while ((line = bf.readLine()) != null) {

				rowIndex++;
				columnIndex = 0;
				findIfInfoInOneLine(line);

			}
			sortIfInfoList();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				bf.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Find the if key in one line and save the if info into ifList. There is a
	 * stack which is used for save the unclosed if statement. It's used to
	 * compute the if's depth. When find the if key, it need to consider some
	 * special case, for example the if string is in comment block or is the
	 * part of one string value.
	 * 
	 * @param line
	 *            specified line
	 */
	private void findIfInfoInOneLine(String line) {
		char[] charArray = line.toCharArray();
		boolean doubleQuotesFlag = false;
		boolean singleQuoteFlag = false;

		if (isEmptyOrCommentLine(line)) {
			return;
		}
		for (int i = 0; i < charArray.length; i++) {

			updateColumnIndex(charArray[i]);

			if (!doubleQuotesFlag && !singleQuoteFlag) {
				if (!commentFlag) {

					if (charArray[i] == '{') {
						increaseBraceCountIfNeed();
						continue;
					} else if (charArray[i] == '}') {
						decreaseBraceCountIfNeed();
						popTheClosedIf();
						continue;
					} else if (charArray[i] == ';') {
						popTheClosedIf();
						continue;
					}
				}
				if (isToggleComment(charArray, i)) {
					break;
				} else if (isBlockComment(charArray, i)) {
					++i;
					commentFlag = !commentFlag;
					continue;
				}

				if (addToStackIfNeed(charArray, i)) {
					continue;
				}

			}
			if (isDoubleQuotes(charArray, i)) {
				doubleQuotesFlag = !doubleQuotesFlag;
			} else if (isSingleQuotes(charArray, i)) {
				singleQuoteFlag = !singleQuoteFlag;
				continue;
			}

		}
	}

	private boolean addToStackIfNeed(char[] charArray, int i) {
		boolean result = false;

		int colIndex = columnIndexOfIfKey(charArray, i);
		if (colIndex != -1) {
			IfInfo ifInfo = new IfInfo(rowIndex, colIndex, false);
			addToStack(ifInfo);
			result = true;
		} else {
			int elseIndex = columnIndexOfElseKey(charArray, i);
			if (elseIndex != -1) {
				IfInfo ifInfo = new IfInfo(rowIndex, elseIndex, true);
				addToStack(ifInfo);
				result = true;
			}
		}

		return result;
	}

	private void decreaseBraceCountIfNeed() {
		if (ifStack.size() > 0) {
			IfInfo info = ifStack.peek();
			info.setBraceCount(info.getBraceCount() - 1);
		}
	}

	private void increaseBraceCountIfNeed() {
		if (ifStack.size() > 0) {
			IfInfo info = ifStack.peek();
			info.setBraceCount(info.getBraceCount() + 1);
			info.setHasBrace(false);
		}
	}

	private void updateColumnIndex(char c) {
		if (c == '\t') {
			columnIndex = columnIndex + 4;
		} else {
			columnIndex++;
		}
	}

	private void popTheClosedIf() {
		while (ifStack.size() > 0) {
			IfInfo info = ifStack.peek();
			if (info.getBraceCount() == 0) {
				if (ifStack.peek().isElse()) {
					ifStack.pop();
				} else {
					ifList.add(ifStack.pop());
				}

			} else {
				break;
			}
		}
	}

	public static boolean isBlockComment(char[] charArray, int i) {
		boolean result = false;
		result = (charArray[i] == '/' && i + 1 <= charArray.length - 1 && charArray[i + 1] == '*')
				|| (charArray[i] == '*' && i + 1 <= charArray.length - 1 && charArray[i + 1] == '/');
		return result;
	}

	public static boolean isToggleComment(char[] charArray, int i) {
		boolean result = false;
		result = (charArray[i] == '/' && i + 1 <= charArray.length - 1 && charArray[i + 1] == '/');

		return result;
	}

	public static boolean isDoubleQuotes(char[] charArray, int i) {
		boolean result = false;

		if (i > 0) {
			result = (charArray[i] == '"' && (charArray[i - 1] != '\'' && charArray[i - 1] != '\\'));
		} else {
			result = (charArray[i] == '"');
		}

		return result;

	}

	public static boolean isSingleQuotes(char[] charArray, int i) {
		boolean result = false;

		result = (charArray[i] == '\'' && (charArray[i - 1] != '\\'));

		return result;
	}

	/**
	 * Get the column index for if key in the specified string
	 * 
	 * @param charArray
	 *            the specified char array
	 * @param i
	 *            the index of the array
	 * @return -1 if there doesn't contain the if key
	 */
	private int columnIndexOfIfKey(char[] charArray, int i) {

		int index = -1;
		int j = 0;

		if (charArray[i] == ' ' || charArray[i] == '\t') {
			j = i + 1;
			if (isContainIf(charArray, j)) {
				index = columnIndex + 1;
			}
		} else if (i == 0 || charArray[i - 1] == ';' || charArray[i - 1] == '{'
				|| charArray[i - 1] == '}') {
			j = i;
			if (isContainIf(charArray, j)) {
				index = columnIndex;
			}
		}
		return index;
	}

	/**
	 * Get the column index for else key in the specified string
	 * 
	 * @param charArray
	 *            the specified char array
	 * @param i
	 *            the index of the array
	 * @return -1 if there doesn't contain the if key
	 */
	private int columnIndexOfElseKey(char[] charArray, int i) {
		int index = -1;
		int j = 0;
		if (true) {
		}

		if (charArray[i] == ' ' || charArray[i] == '\t') {
			j = i + 1;
			if (isContainElse(charArray, j)) {
				index = columnIndex + 1;
			}
		} else if (i == 0 || charArray[i - 1] == '}') {
			j = i;
			if (isContainElse(charArray, j)) {
				index = columnIndex;
			}
		}
		return index;
	}

	public static boolean isContainIf(char[] charArray, int i) {
		boolean result = false;
		if (i + 1 <= charArray.length - 1
				&& charArray[i] == 'i'
				&& charArray[i + 1] == 'f'
				&& ((i + 2 <= charArray.length - 1 && (charArray[i + 2] == ' ' || charArray[i + 2] == '(')) || i + 1 == charArray.length - 1)) {
			result = true;
		}

		return result;
	}

	public static boolean isContainElse(char[] charArray, int i) {
		boolean result = false;
		if (i + 3 <= charArray.length - 1
				&& charArray[i] == 'e'
				&& charArray[i + 1] == 'l'
				&& charArray[i + 2] == 's'
				&& charArray[i + 3] == 'e'
				&& ((i + 4 <= charArray.length - 1 && (charArray[i + 4] == ' '
						|| charArray[i + 4] == '{' || charArray[i + 4] == 'i')) || i + 3 == charArray.length - 1)) {
			result = true;

		}

		return result;
	}

	private void addToStack(IfInfo ifInfo) {

		if (ifStack.size() > 0) {
			if (ifStack.peek().isElse()) {
				ifStack.pop();
				ifInfo.setElseIf(true);
				if (ifList.get(ifList.size() - 1).hasBrace()) {
					ifList.get(ifList.size() - 1).addChildren(ifInfo);
					ifInfo.setDepth(ifList.get(ifList.size() - 1).getDepth() + 1);
				} else {
					ifInfo.setDepth(ifList.get(ifList.size() - 1).getDepth());
				}
			} else {
				ifStack.peek().addChildren(ifInfo);
				ifInfo.setDepth(ifStack.peek().getDepth() + 1);
			}
		}

		ifStack.push(ifInfo);
	}

	private boolean isEmptyOrCommentLine(String line) {
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

	public String getSimpleIfInfos() {
		StringBuilder sb = new StringBuilder();
		sb.append("totally:");
		sb.append(ifList.size());
		sb.append(" positions:");
		for (IfInfo ifInfo : ifList) {
			sb.append(ifInfo.toString());
		}

		return sb.toString();
	}

	public String getFullIfInfos() {
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

	public String getNestedIfInfos() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (IfInfo ifInfo : ifList) {
			if (ifInfo.getDepth() > 0) {
				count++;
				sb.append("[position:");
				sb.append(ifInfo.toString());
				sb.append(" depth:");
				sb.append(ifInfo.getDepth() + "]\n");
			}

		}
		sb.append("Nested if number:" + count);
		return sb.toString();
	}

	public String ifInfosAndFileName() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + ":");
		sb.append(getSimpleIfInfos() + "\n");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void sortIfInfoList() {
		Collections.sort(ifList, new Comparator<IfInfo>() {

			@Override
			public int compare(IfInfo o1, IfInfo o2) {
				if (o1.getX() < o2.getX()) {
					return -1;
				} else if (o1.getX() > o2.getX()) {
					return 1;
				} else if (o1.getX() == o2.getX() && o1.getY() < o1.getY()) {
					return -1;
				} else if (o1.getX() == o2.getX() && o1.getY() > o1.getY()) {
					return 1;
				}
				return 0;
			}
		});
	}

}
