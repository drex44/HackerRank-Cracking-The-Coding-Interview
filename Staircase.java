package ctci;
//https://www.hackerrank.com/challenges/ctci-recursive-staircase


import java.util.Scanner;

public class Staircase {
	
	static int mem[] = new int[10000];
	static{
		for (int i = 0; i < mem.length; i++) {
			mem[i]=-1;
		}
	}
	
	static int climb(int n){
		if (n<0)
			return 0;
		else if(mem[n]!=-1)
			return mem[n];
		else if(n==0)
			return 1;
		else {
			int sum=0;
			for (int i = 1; i < 4; i++) {
				sum+=climb(n-i);
			}
			mem[n]=sum;
			return sum;
		}
	}
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			System.out.println(climb(n));
		}
	}

}
