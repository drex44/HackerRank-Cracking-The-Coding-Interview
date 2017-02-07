package ctci;
//https://www.hackerrank.com/challenges/ctci-ransom-note

import java.util.*;

public class RansomNote {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine = new String();

		Hashtable<String, Integer> set = new Hashtable<>();

		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine = in.next();
			if(set.containsKey(magazine)){
				int t = set.get(magazine);
				set.replace(magazine, ++t);
			}
			else
				set.put(magazine, 1);
		}
		String ransom;;
		boolean f = true;
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom = in.next();
			if (set.containsKey(ransom)) {
				int t = set.get(ransom);
				if(t>1)
					set.replace(ransom, --t);
				else
					set.remove(ransom);
			}else{
				f = false;
				break;
			}
		}
		if (f)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
