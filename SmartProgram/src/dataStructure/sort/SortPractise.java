package dataStructure.sort;

public class SortPractise {

	public static void bubbleSort(int[] a) {
		int size = a.length;
		for (int i = 0 ;i < size; i++) {
			for (int j = 0 ;j < size-i-1 ;j++) {
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	public static void directInsert(int[] a) {
		int size = a.length;

		for (int i = 0 ;i < size-1 ; i++ ){
			int tmp = a[i+1];
			for(int j = i+1 ; j > 0 ; j--) {
				if (tmp < a[j-1]) {
					a [j] = a[j-1];
					if (j == 1) {
						a[j-1] = tmp;
					}
				}else {
					a[j] = tmp;
					break;
				}
			}
		}
	}
	
	public static int binarySearch(int[] a ,int from, int to, int v) {
//		int idx = (to - from)/2 + from;
//		if(a[idx] == v) {
//			return idx;
//		} else if(a[idx] > v ) {
//			if(from == idx) {
//				return -1;
//			}else {
//				return binarySearch(a, from, idx, v);	
//			}
//		}else {
//			idx = idx +1;
//			if(idx == to) {
//				if(a[idx] == v) {
//					return idx;
//				}else {
//					return -1;
//				}
//			}else {
//				return binarySearch(a, idx, to, v);		
//			}
//		} 
		if(from>to || to<0 ||from<0)
		{
			System.out.println("Invalid index");
			return -1;
		}
			
		if(from==to)
		{
			if(a[from]==v)
				return from;
			else
				return -1;
		}else if(from < to)
		{
			int idx = (to - from)/2 + from;
			if(a[idx] == v) 
				return idx;
			else if(a[idx] > v)
				return binarySearch(a, from, idx-1, v);	
			else
				return binarySearch(a, idx+1, to, v);
		}
		else
			return -1;
	}
	
	public static void mergeSortZ(int[] a, int from, int to) {
		int idx = (to -from)/2 + from ;
		if(to > from) {
			mergeSort(a, from, idx);
			mergeSort(a, idx+1, to);
			
			int len1= idx - from + 1;
			int len2= to -idx;
			
			int[] left = new int[len1];
			int[] right = new int[len2];
			for(int i = 0,j = from ;i <len1;i++,j++) {
				left[i] = a[j];
			}
			
			for (int i = idx+1,j = 0;j < len2;i++,j++){
				right[j] = a[i];
			}
			
			for (int i = from,j = 0,k = 0;i<= to;i++) {
				if (j > len1-1) {
					a[i] = right[k++];
					continue;
				} else if ( k > len2-1) {
					a[i] = left[j++];
					continue;
				}
				
				if (left[j] <= right[k] ) {
					a[i] = left[j++];
				}else {
					a[i] = right[k++];
				}
			}
			
		}
		
		
	}
	
	public static void mergeSort(int[] a, int from, int to) {
		int idx = (to -from)/2 + from ;
		if(to > from) {
			mergeSort(a, from, idx);
			mergeSort(a, idx+1, to);
		}
		int[] b = new int[to - from +1];
		for (int i = 0,j = from,k = idx +1;i<to-from+1;i++) {
			if (j > idx) {
				b[i] = a[k++];
				continue;
			} else if ( k > to) {
				b[i] = a[j++];
				continue;
			}
			
			if (a[j] <= a[k] ) {
				b[i] = a[j++];
			}else {
				b[i] = a[k++];
			}
		}
		
		for (int i = from; i <= to; i++) {
			a[i] = b[i-from];
		}
	}
	
	public static void quickSort(int[] a , int from ,int to) {
		if(from >=to) {
			return;
		}
		
		int tmp = a[from];
		int i = from;
		int j = to;
		
		while (i<j) {
			while(i<j && a[j] >= tmp) {
				j--;
			}
			
			if(i<j) {
				a[i++] = a[j];
			}
			
			while(i<j && a[i] <= tmp) {
				i++;
			}
			if(i<j) {
				a[j--]= a[i];
			}
		}
		a[i] =  tmp;
		quickSort(a, from,i-1);
		quickSort(a, i+1, to);
	}
	@Deprecated
	public static void directInsertForDel(int[] a) {
		int size = a.length;
		for(int i = 0 ; i <size ; i++) {
			for (int j = size -1 ; j > i ; j--) {
				if (a[j] < a[j-1]) {
					int tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
				}
			}
		}
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
