// Brett Fazio, Segment Tree with Range Min Query
// for Range Max just flip the < to >

import java.util.Arrays;
public class RangeMinimumQuery {
	
	static int[] delta, high, low, min, input;
	public static void main(String[] args) {
		input  =new int[] {1,3,4,7,9,3,4};
		// kids are 2i and 2i+1

		delta= new int[input.length*4+1];
		high= new int[input.length*4+1];
		low= new int[input.length*4+1];
		min= new int[input.length*4+1];
		
		Arrays.fill(min, Integer.MAX_VALUE);	
		init(1,0,input.length-1);
		for (int i = 0; i < input.length; i++) {
			update(1,input[i],i,i);
		}
		System.out.println(rmq(1,0,6));
	}
	
	static void init(int v, int l, int r) {
		low[v] = l;
		high[v] = r;
		if (r-l == 0) {
			return;
		}else {
			// build children
			int m = (l+r)/2;
			init(2*v, l, m);
			init(2*v+1, m+1, r);
		}
	}
	
	static int rmq(int v, int l, int r) {
		if (high[v] < l || r < low[v]) {
			return Integer.MAX_VALUE;
		}else if (l <= low[v] && high[v] <= r) {
			return min[v];
		}
		int minl = rmq(2*v, l, r);
		int minr = rmq(2*v+1, l, r);
		
		return Math.min(minl,minr);
	}
	
	static void update(int v, int value, int l, int r) {
		if (high[v] < l || r < low[v]) {
			return;
		}else if (l <= low[v] && high[v] <= r) {
			delta[v] = Math.min(min[v], value);
			return;
		}

		update(v*2,value,l,r);
		update(v*2+1,value,l,r);
		update(v);
	}
	
	static void update(int v) {
		min[v] = Math.min(min[v*2],min[v*2+1]);
	}
}
