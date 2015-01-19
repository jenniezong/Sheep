public class MergeSort {

	public static void sort(int a[]) {
		mergeRecursion(a, 0, a.length - 1);

	}

	public static void mergeRecursion(int[] a, int left, int right) {

		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;
		mergeRecursion(a, left, mid);
		mergeRecursion(a, mid+1, right);
		
		merge(a, left, mid, right);

	}

	public static void merge(int[] a, int left, int center, int right) {
		
		int[] tmpArray = new int[a.length];
		int tmpIndex = left;
		int leftIndex = left;
		int rightIndex = center+1;
		int tmp = left;
		
		while (leftIndex <= center && rightIndex <= right) {
			
			if(a[leftIndex] <= a[rightIndex]){
				
	        	tmpArray[tmpIndex++] = a[leftIndex++];
	        	
	        }else {
	        	
	            tmpArray[tmpIndex++] = a[rightIndex++];	
	        }
		}
		
		while (leftIndex <= center) {
			
			tmpArray[tmpIndex++] = a[leftIndex++];
		}
		
		while (rightIndex <= right) {
			
			tmpArray[tmpIndex++] = a[rightIndex++];	
		}
		while (tmp <= right) {
			
			a[tmp] = tmpArray[tmp++]; 
		}
        
	}

	public static void main(String[] args) {
		
		int[] a = UtilSort.randomIntArray(5, 15);
		UtilSort.beforeSortPrint();
		UtilSort.printIntArray(a);

		MergeSort.sort(a);

		UtilSort.afterSortPrint();
		UtilSort.printIntArray(a);
	}

}
