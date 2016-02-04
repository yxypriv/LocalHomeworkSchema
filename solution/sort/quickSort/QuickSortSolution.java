package sort.quickSort;

import sort.SortChecker;
import sort.mergeSort.MergeSortSolution;
import utils.ArrayUtils;

public class QuickSortSolution implements QuickSortInterface {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public <T extends Comparable<T>> void quickSort(T[] arr, int s, int e) {
		if (s >= e) {
			return;
		}
		T pivit = arr[s];
		int low = s;
//		System.out.println(Arrays.toString(arr));
//		System.out.println(pivit);
		for (int i = s + 1; i <= e; i++) {
			if (arr[i].compareTo(pivit) < 0) {
				ArrayUtils.swap(arr, i, low + 1);
				low++;
			}
		}
		ArrayUtils.swap(arr, s, low);
//		super.saveInnerParameters(low, new int[] { s, e }, arr);
		quickSort(arr, s, low - 1);
		quickSort(arr, low + 1, e);
	}
	
	public static void main(String[] args) {
		SortChecker cheker = new SortChecker(QuickSortSolution.class);
		System.out.println(cheker.checkAlgorithm());
	}
}
