package sort.mergeSort;

public class MergeSortSolution implements MergeSortInterface {

	@Override
	public <T extends Comparable<T>> void mergeSort(T[] arr) {
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
		MergeSortInterface ms = new MergeSortSolution();
		Integer[] arr = new Integer[] { 4, 1, 5, 3, 2, 7 };
		ms.mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();

		String[] arr2 = new String[] { "ab", "cd", "ac", "bd", "abc", "cde" };
		ms.mergeSort(arr2);
		for (String s : arr2)
			System.out.print(s + ",");
		System.out.println();

	}
}
