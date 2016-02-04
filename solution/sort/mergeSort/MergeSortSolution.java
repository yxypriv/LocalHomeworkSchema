package sort.mergeSort;

import sort.SortChecker;

public class MergeSortSolution implements MergeSortInterface {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private <T extends Comparable<T>> void mergeSort(T[] arr, int s, int e) {
		if (s >= e)
			return;
		int mid = (s + e) / 2;
		mergeSort(arr, s, mid);
		mergeSort(arr, mid + 1, e);

		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable[e - s + 1];
		int i = 0, i1 = s, i2 = mid + 1;
		while (i < e - s + 1) {
			if (i1 <= mid && (i2 > e || arr[i1].compareTo(arr[i2]) < 0)) {
				temp[i] = arr[i1];
				i1++;
			} else {
				temp[i] = arr[i2];
				i2++;
			}
			i++;
		}
		for (int j = s; j <= e; j++) {
			arr[j] = temp[j - s];
		}
	}

	public static void main(String[] args) {
		SortChecker cheker = new SortChecker(MergeSortSolution.class);
		System.out.println(cheker.checkAlgorithm());
	}
}
