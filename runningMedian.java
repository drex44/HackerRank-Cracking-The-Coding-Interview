//https://www.hackerrank.com/challenges/ctci-find-the-running-median

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1,
				Collections.reverseOrder());

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int temp;

		while (n-- > 0) {
			temp = in.nextInt();
			maxHeap.add(temp);

			if (maxHeap.size() > minHeap.size() + 1)
				minHeap.add(maxHeap.poll());

			if (minHeap.size() > 0 && maxHeap.size() > 0) {
				int a = minHeap.peek();
				int b = maxHeap.peek();
				if (b > a) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(minHeap.poll());
				}
			}

			if (n % 2 == 0)
				System.out.println(((float) maxHeap.peek() + minHeap.peek()) / 2);
			else
				System.out.println((float)maxHeap.peek());
		}
    }
}
