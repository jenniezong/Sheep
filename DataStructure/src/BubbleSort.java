
/**
 * @author enanzon
 * 
 */
public class BubbleSort {

	public static void sort(int[] a) {

		int len = a.length;
		boolean isOk = false;

		for (int j = 0; j < len - 1 && !isOk; j++) {

			isOk = true;
			for (int i = len - 1; i > j; i--) {

				if (a[i] < a[i - 1]) {
					UtilSort.swapData(a, i, i-1);
					isOk = false;
				}
			}
		}

	}

	/**
	 * @param a
	 */
	public void switchTwoData(int[] a) {

	}

	public static void main(String[] args) {

		int[] a = UtilSort.randomIntArray(10, 15);
		UtilSort.beforeSortPrint();
		UtilSort.printIntArray(a);

		BubbleSort.sort(a);

		UtilSort.afterSortPrint();
		UtilSort.printIntArray(a);
	}

}
