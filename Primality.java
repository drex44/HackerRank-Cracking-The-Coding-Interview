package ctci;
//https://www.hackerrank.com/challenges/ctci-big-o

import java.util.ArrayList;
import java.util.Scanner;

public class Primality {

	public static void main(String[] args) {

		int LIMIT;
		LIMIT = 100000;

		boolean primes[] = new boolean[LIMIT];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}

		ArrayList<Integer> p = new ArrayList<>();
		for (int i = 2; i < LIMIT; i++) {
			if (primes[i] == true) {
				p.add(i);
				for (int j = i * 2; j < LIMIT; j += i) {
					primes[j] = false;
				}
			}
		}

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt();
			boolean flag = true;

			if (p.contains(m)) {
				System.out.println("Prime");
			} else {
				for (int a : p) {
					if (m==1 || m % a == 0) {
						System.out.println("Not prime");
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println("Prime");
					p.add(m);
				}
			}
		}

		// System.out.println(p.size());

	}

}
