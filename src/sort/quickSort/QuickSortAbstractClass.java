package sort.quickSort;

import java.util.ArrayList;
import java.util.List;

public abstract class QuickSortAbstractClass {
	public abstract <T extends Comparable<T>> void quickSort(T[] arr);

	private static class QuickSortInnerParameters<T extends Comparable<T>> {
		public int pivitIndex;
		public int[] range;
		public T[] arr;
	}

	public List<QuickSortInnerParameters<? extends Comparable<?>>> list = new ArrayList<QuickSortAbstractClass.QuickSortInnerParameters<? extends Comparable<?>>>();

	public <T extends Comparable<T>> void saveInnerParameters(int pivitIndex, int[] range,
			T[] arr) {
		QuickSortInnerParameters<T> param = new QuickSortInnerParameters<T>();
		param.pivitIndex = pivitIndex;
		param.range = range;
		param.arr = arr.clone();
		list.add(param);
	}

	public List<QuickSortInnerParameters<? extends Comparable<?>>> getList() {
		return list;
	}
}
