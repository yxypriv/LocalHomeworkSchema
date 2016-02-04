package sort.heapSort;

import sort.SortChecker;
import utils.ArrayUtils;

public class HeapSortSolution implements HeapSortInterface {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++)
			heapBuild(arr, i);
		int heap_length = arr.length;
		while (heap_length > 0) {
			ArrayUtils.swap(arr, 0, heap_length - 1);
			heap_length--;
			heapify(arr, 0, heap_length);
		}
	}

	<T extends Comparable<T>> void heapBuild(T[] arr, int index) {
		if (index == 0)
			return;
		int parent = parentIndex(index);
		if (arr[index].compareTo(arr[parent]) > 0) {
			ArrayUtils.swap(arr, index, parent);
		}
		heapBuild(arr, parent);
	}

	<T extends Comparable<T>> void heapify(T[] arr, int index, int heapLength) {
		if (index >= heapLength) {
			return;
		}
		int leftChild = leftChild(index);
		if (leftChild >= heapLength)
			return;
		int maxChild = leftChild;

		int rightChild = rightChild(index);
		if (rightChild < heapLength) {
			if (arr[rightChild].compareTo(arr[leftChild]) > 0) {
				maxChild = rightChild;
			}
		}

		if (arr[maxChild].compareTo(arr[index]) > 0) {
			ArrayUtils.swap(arr, index, maxChild);
		}

		heapify(arr, maxChild, heapLength);
	}

	int parentIndex(int index) {
		return (index - 1) / 2;
	}

	boolean isRoot(int index) {
		return index == 0;
	}

	int leftChild(int index) {
		return index * 2 + 1;
	}

	int rightChild(int index) {
		return (index + 1) * 2;
	}

	public static void main(String[] args) {
		SortChecker checker = new SortChecker(HeapSortSolution.class);
		System.out.println(checker.checkAlgorithm());
	}
}
