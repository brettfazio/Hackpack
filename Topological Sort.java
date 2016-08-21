class Graph {
	int numV; //Number of vertices. Will be 26 in this case.
	ArrayList<Integer>[] edges; //ArrayLists to store edges.
	StringBuilder builder; //The StringBuilder to present the sort.
	
	Graph(int v) {
		numV = v;
		builder = new StringBuilder();
		edges = new ArrayList[numV];
		for(int i = 0; i < numV; i++) edges[i] = new ArrayList<Integer>();
	}
	
	boolean addEdge(int u, int v) {
		if(edges[u].contains(v)) return false;
		edges[u].add(v);
		return true;
	}
	
	void recursiveTopSort(boolean[] V, Stack<Character> stack, int at) {
		for(int edge : edges[at]) {
			if(!V[edge]) {
				V[edge] = true;
				recursiveTopSort(V, stack, edge);
			}
		}
		stack.push((char)(at+'a'));
	}
	
	void topologicalSort() {
		Stack<Character> stack = new Stack<Character>();
		boolean[] V = new boolean[numV];
		for(int i = 0; i < numV; i++) {
			if(!V[i]) {
				V[i] = true;
				recursiveTopSort(V, stack, i);
			}
		}
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}
	}
	
	boolean cycleCheck(int at, boolean[] V) {
		V[at] = true;
		for(int i : edges[at]) {
			if(V[i]) {
				return true; //hasCycle
			}
			V[i] = true;
			return cycleCheck(i, V);
		}
		return false;
	}
	
	String getSort() {
		return builder.toString();
	}
}