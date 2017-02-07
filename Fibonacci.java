package ctci;
//https://www.hackerrank.com/challenges/ctci-fibonacci-numbers

import java.util.*;

public class Fibonacci {

	static int arr[] = new int[40];
	static {
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < 40; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
	}

	public static int fibonacci(int n) {
		// Complete the function.
		return arr[n];

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println(fibonacci(n));
	}

}
