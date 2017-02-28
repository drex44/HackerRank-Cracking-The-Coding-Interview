package ctci;
//https://www.hackerrank.com/challenges/ctci-merge-sort


import java.util.Scanner;

public class MergeSort {

	public static int mergeSort(int arr[]){
		return mergesort(arr,new int[arr.length],0,arr.length-1);
	}
	public static int mergesort(int[] arr, int temp[], int LeftStart, int RightEnd){
		int swaps = 0;
		if(LeftStart>=RightEnd){
			return 0;
		}
		int mid = (LeftStart + RightEnd) / 2;
		swaps = mergesort(arr, temp, LeftStart, mid);
		swaps += mergesort(arr, temp, mid+1, RightEnd);
		swaps+= merge(arr, temp, LeftStart, RightEnd);
		return swaps;
	}
	
	public static int merge(int[] arr, int[] temp, int leftStart, int rightEnd) {

		int swaps=0;
		int leftEnd = (leftStart + rightEnd) /2;
		int rightStart = leftEnd + 1;
		
		int size = rightEnd - leftStart + 1;
		int index = leftStart;
		int left = leftStart;
		int right = rightStart;
		while(left<=leftEnd && right<=rightEnd){
			if(arr[left]<= arr[right]){
				temp[index] = arr[left];
				left++;
			}
			else{
				temp[index] = arr[right];
				right++;
				swaps += (leftEnd + 1  - left);
			}
			index++;
		}
		
		System.arraycopy(arr, left, temp, index, leftEnd-left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
		return swaps;
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(mergeSort(arr));
			
		}

	}

}
