// Brett Fazio Permutations (rearrangements)
public class permutation {

	static Object[] item, perm;
	static boolean[] used;
	static int count;
	public static void main(String[] args) {
		int MAX_ITEM = 5;
		
		item = new Object[MAX_ITEM]; 
		// PUT ITEMS INTO item HERE
		perm = new Object[MAX_ITEM];
		used = new boolean[MAX_ITEM];
		count = MAX_ITEM;
		
		permute(0);
	}
	
	public static void permute(int pos) {
		int j = 0;
		if (pos >= count) {
			// process current array
		}else {
			for (j = 0; j < count; j++) {
				if (!used[j]) { 
					used[j] = true;
					perm[pos] = item[j];
					permute(pos+1);
					used[j] = false;
				}
			}
		}
	}

}
