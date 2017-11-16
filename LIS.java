// Brett Fazio, LIS (Longest Increasing Subsequence)

public class LIS {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,0,1,2,3,4,5,6};
		
		int maxl = 0;
		int l = 0;
		int r = 0;
		int cur = 0;
		int cl = 0;
		int cr = 0;
		int prev = Integer.MIN_VALUE;
		for (int i = 0;i < a.length; i++) {
			if (a[i] >= prev) {
				cr++;
			}else {
				for (int k = cl; k < i; k++) {
					if (a[k] > a[i]) {
						cl = k+1;
					}
				}
			}
			
			prev = a[i];
			cur = cr-cl+1;
			
			if (cur > maxl) {
				maxl =cur;
				l = cl;
				r = cr;
			}
		}
		// l and r are currently zero based.
		System.out.println(maxl + " L: " + l + " R: " + r);
	}

}
