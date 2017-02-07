package ctci;
//https://www.hackerrank.com/challenges/ctci-lonely-integer

import java.util.*;

public class LonelyInteger {

	public static int lonelyInteger(int[] a) {
		BitSet set = new BitSet(a.length / 2 + 1);
		for (int i : a) {
			set.flip(i);
		}
		return set.nextSetBit(0);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		System.out.println(lonelyInteger(a));
	}

}
