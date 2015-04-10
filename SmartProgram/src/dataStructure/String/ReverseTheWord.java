package dataStructure.String;

/**
 * For example: "How are you" After reverse:"you are How"
 * 
 * @author enanzon
 *
 */
public class ReverseTheWord {

	public static String reverseWord(String sentence) {
		String[] words = sentence.split("\\s{1,}");

		StringBuffer sb = new StringBuffer();
		for (int i = words.length - 1; i >= 0; i--) {

			sb.append(words[i] + " ");
		}

		return sb.toString();

	}

	public static void main(String[] args) {

		System.out.println(reverseWord("How are you"));

	}

}
