package dataStructure.sort;

public class SortForOracle {

	public static int binarySearch(int[] a, int from, int to, int val) {
		
		if(to < from) {
			System.out.println("Invalid argument!");
			return -1;
		}
		if(from == to ) {
			if(a[from] == val) {
				return from;
			}
			return -1;
		}
		
		int idx = (from+to)/2;
		if(a[idx] == val) {
			return idx;
		}else if(a[idx] < val) {
			return binarySearch(a, idx+1, to, val);
		} else {
			return binarySearch(a, from, idx-1, val);
		}
		
	}
	
	public static void mergeSort(int[]a, int from ,int to) {
		
		if(from < to) {
			int idx = (from+to)/2;
			mergeSort(a, from, idx);
			mergeSort(a, idx+1, to);
			
			merge(a,from,idx,to);
		}
		
	}
	
	private static void merge(int[]a, int from, int idx, int to) {
		
		int leftLen = idx-from+1;
		int rightLen = to - idx;
		
		int[] left = new int[leftLen];
		int[] right = new int[rightLen];
		
		for (int i = from,j=0;j<leftLen;i++,j++) {
			left[j] = a[i];
		}
		
		for(int i = idx+1,j=0; j<rightLen;i++,j++) {
			right[j] = a[i];
		}
		
		int i = from,j=0, k = 0;
		
		for(; j< leftLen && k < rightLen;i++){
			
			if(left[j] <= right[k]) {
				a[i] = left[j++];
				
			}else {
				a[i] = right[k++];
			}
			
		}
		
		if(j<leftLen) {
			for(int m = j; m< leftLen ;m++,i++) {
				a[i] = left[m];
			}
		} 
		if(k < rightLen) {
			for (int m = k; m< rightLen;m++,i++) {
				a[i] = right[m];
			}
		}
	}
	
	public static void quickSort(int[]a, int from ,int to) {
		
		if(from >= to) {
			return;
		}
		int idx = from , tmp = a[from];
		int i = from, j = to;
		while(i<j) {
			while(i<j &&a[j] > tmp) {
				j--;
			}
			if(i < j) {
				a[i++] = a[j];
			}
			
			while(i<j &&a[i] < tmp ) {
				i++;
			}
			
			if(i<j) {
				a[j--] = a[i];
			}
		}
		
		a[i] = tmp;
		idx = i;
		
		quickSort(a, from, idx-1);
		quickSort(a, idx+1, to);
		
	}
	
	public static void main(String[] args) {
		int[] a = UtilSort.randomIntArray(10, 15);
		UtilSort.beforeSortPrint();
		UtilSort.printIntArray(a);
        
		quickSort(a,0,9);

		UtilSort.afterSortPrint();
		UtilSort.printIntArray(a);
		System.out.println();
		System.out.println("index*****************"+binarySearch(a, 0, 9, 5));

	}

}
