class DSU {
	int[] root;
	int[] height;
	int n;
	
	DSU(int n) {
		this.n = n;
		root = new int[n];
		height = new int[n];
		for(int i = 0; i < n; i++) 
			root[i] = i;
	}
	
	int findParent(int idx) {
		if(root[idx] != idx) return findParent(root[idx]);
		return idx;
	}
	
	boolean union(int x, int y) {
		int parX = findParent(x);
		int parY = findParent(y);
		if(parX == parY) return false;
		if(height[parX] < height[parY]) {
			root[parY] = parX;
			height[parX] += height[parY]+1;
		} else {
			root[parX] = parY;
			height[parY] += height[parX]+1; 
		}
		return true;
	}
}
