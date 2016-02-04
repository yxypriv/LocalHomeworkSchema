package sort;

import sort.heapSort.HeapSortSolution;
import sort.mergeSort.MergeSortSolution;
import sort.quickSort.QuickSortSolution;

public class SortCheckingMain {
	public static void main(String[] args) {
		Class<? extends SortInterface>[] candidates = new Class[] { HeapSortSolution.class,
				MergeSortSolution.class, QuickSortSolution.class };
		for (Class c : candidates) {
			SortChecker checker = new SortChecker(c);
			System.out.println("Checking " + c.getCanonicalName());
			System.out.println(checker.checkAlgorithm());
		}
	}
}
