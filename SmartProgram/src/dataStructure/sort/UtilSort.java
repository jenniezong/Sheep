package dataStructure.sort;
import java.util.Random;

public final class UtilSort {
	
	private UtilSort() {
		throw new AssertionError();
	}

	public static void printIntArray(int[] a) {

		for (int i : a) {
			System.out.print(i + "\t");
		}
	}

	public static int[] randomIntArray(int len, int maxVal) {

		int[] a = new int[len];
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			int rdm = random.nextInt(maxVal);

			a[i] = rdm;
		}
		return a;

	}
	
	public static void swapData(int[] data, int a, int b) {
		int t = data[a];
		data[a] = data[b];
		data[b] = t;

	}

	public static void beforeSortPrint() {
		System.out.println("Before sort  ****************************");
	}

	public static void afterSortPrint() {
		System.out.println("\nAfter sort  *****************************");
	}

}
