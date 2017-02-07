package ctci;
//https://www.hackerrank.com/challenges/ctci-balanced-brackets

import java.util.*;

public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
		Stack<String> st = new Stack<>();
		if (expression != null) {
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if ((c == '}' || c == ']' || c == ')')) {
					char d;
					if (st.isEmpty())
						return false;
					else
						d = st.pop().toCharArray()[0];
					if ((d == '[' && c == ']') || (d == '{' && c == '}') || (d == '(' && c == ')')) {

					} else {
						return false;
					}
				} else {
					st.push(c + "");
				}
			}
			if (st.isEmpty())
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}

}
