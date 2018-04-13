// brett fazio, fenwick tree, sum for range

import java.util.*;
public class FenwickTree {
	static int[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tree = new int[n+1];
		tree[0] = 0;
		for (int i = 1; i < n; i++) {
			update(i,sc.nextInt());
		}
		// sum for range
		System.out.println(query(0,3));
	}
	public static int sum(int i) {
		int res = 0;
		while (i > 0) {
			res += tree[i];
			i &= (i-1);
		}
		return res;
	}
	public static void update(int i, int sum) {
		while (i <= tree.length) {
			tree[i] += sum;
			i += (i) & (-i); //Integer.lowestOneBit(i);
		}
	}
	public static int query(int i, int j) {
		return sum(j) - sum(i-1);
	}
	public static int findKth(int k) {
		int lastK = tree.length;
		int pos = 0;
		int pow2 = Integer.highestOneBit(lastK);
		while (pow2 > 0) {
			if (pos + pow2 <= tree.length) {
				if (tree[pos+pow2] >= k) {
					lastK = Math.min(lastK, pos+pow2);
				}else {
					pos += pow2;
					k -= tree[pos];
				}
			}
			pow2 >>= 1;
		}
		return lastK;
	}
}
