public class InsertionSort {

	public static void sort(int[] a) {
		int tmp;
		for (int i = 1; i < a.length; i++) {

			tmp = a[i];
			int j = i - 1;
			while (j >= 0 && tmp < a[j]) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = tmp;

		}
	}

	public static void main(String[] args) {

		int[] a = UtilSort.randomIntArray(10, 15);
		UtilSort.beforeSortPrint();
		UtilSort.printIntArray(a);

		InsertionSort.sort(a);

		UtilSort.afterSortPrint();
		UtilSort.printIntArray(a);
	}

}
