import java.util.*;

public class Subsetsum {
	public static void main(String[] args) {
		int[] a = {5, -12, 25, 3, -2512, 45, -1};
		int n = a.length;
		int goal = 69;
		boolean found = false;
		ArrayList<Integer> set = new ArrayList<>();
		subset:
			for(int subset = 0; subset < (1 << n); subset++) {
				int sum = 0;
				for(int i = 0; i < n; i++) {
					int res = subset & (1 << i);
					if(res != 0) {
						sum += a[i];
					}
				}
				if(sum == goal) {
					found = true;
					break subset;
				}
			}
		if(found) System.out.println("Found " + goal);
		else System.out.println("Not possible");
	} 
}
