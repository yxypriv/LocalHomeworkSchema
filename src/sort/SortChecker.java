package sort;

import java.util.Arrays;
import java.util.Random;

import utils.RandomStringUtils;

public class SortChecker {
	public SortChecker(Class<? extends SortInterface> target) {
		try {
			this.method = target.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public boolean checkAlgorithm() {
		return checkingIntegerSimple() && checkingIntegerNormal() && checkingIntegerLarge()
				&& checkingString();
	}

	Random rand = new Random();
	RandomStringUtils randString = new RandomStringUtils();

	private boolean checkingString() {
		System.out.println("Checking String");
		randString.setLengthRange(10, 20);
		String[] arr = new String[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randString.nextRandomString();
		}
		return checking(arr, 1000);
	}

	private boolean checkingIntegerSimple() {
		System.out.println("Checking Integer Simple");
		Integer[] arr = new Integer[50];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(60);
		}
		return checking(arr, 20l);
	}

	private boolean checkingIntegerNormal() {
		System.out.println("Checking Integer Normal");
		Integer[] arr = new Integer[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt();
		}
		return checking(arr, 1000l);
	}

	private boolean checkingIntegerLarge() {
		System.out.println("Checking Integer Large");
		Random rand = new Random();
		Integer[] arr = new Integer[1000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt();
		}
		return checking(arr, 4000l);
	}

	private <T extends Comparable<T>> boolean checking(T[] arr, long time_limit) {
		T[] ans = arr.clone();
		long t0 = System.currentTimeMillis();
		method.sort(arr);
		long time_cost = System.currentTimeMillis() - t0;
		System.out.println("Time cost: " + time_cost);
		if (time_cost > time_limit) {
			System.out.println("Failded Due to Timeout");
			return false;
		}
		Arrays.sort(ans);
		for (int i = 0; i < arr.length; i++) {
			if (!ans[i].equals(arr[i])) {
				System.out.println("Failed due to incorrect solution");
				System.out.println("Answer:\t" + Arrays.toString(ans));
				System.out.println("Result:\t" + Arrays.toString(arr));
				return false;
			}
		}
		return true;
	}

	SortInterface method;
}
