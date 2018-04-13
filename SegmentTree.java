// Brett Fazio, segment tree

import java.util.*;
public class SegmentTree {

	static int[] delta, minval, low, high;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		
		delta = new int[4*nodes+1];
		minval = new int[4*nodes+1];
		low = new int[4*nodes+1];
		high = new int[4*nodes+1];
		
	}
	
	public static void prop(int i) {
		delta[2*i] += delta[i];
		delta[2*i+1] += delta[i];
		delta[i] = 0;
	}
	
	public static void update(int i) {
		minval[i] = Math.min(minval[2*i]+delta[2*i], minval[2*i+1] + delta[2*i+1]);
	}

	public static void init(int i, int left, int right) {
		low[i] = left;
		high[i] = right;
		if (left == right) return;
		int m = (left + right)/2;
		init(2*i, left, m);
		init(2*i+1, m+1, right);
	}
	
	public static void add (int i, int left, int right, int x) {
		if (high[i] < left ||right < low[i]) return;
		if (left <= low[i] && high[i] <= right) {
			delta[i] += x;
			return;
		}
		prop(i); 
		add(2*i, left, right, x);
		add(2*i+1, left, right, x);
		update(i);
	}
	
	public static int minQuery(int i, int left, int right) {
		if (high[i] < left || right < low[i]) {
			return Integer.MAX_VALUE;
		} if (left <= low[i] && high[i] <= right) {
			return delta[i] + minval[i];
		}
		prop(i);
		int minleft = minQuery(2*i, left, right);
		int minright = minQuery(2*i+1, left, right);
		update(i);
		return Math.min(minleft, minright);
	}
}
