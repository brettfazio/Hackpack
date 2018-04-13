// brett fazio, flow

import java.util.*;
public class Flow {
	static int source, sink, nodes, edges;
	static boolean[] seen;
	static int[][] cap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nodes = sc.nextInt();
		edges = sc.nextInt();
		// take in the amount of possible flow between nodes
		seen = new boolean[nodes];
		cap = new int[nodes][nodes]; 
		for (int i = 0; i < edges; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int weight = sc.nextInt();
			cap[a][b] = weight;
		}
		source = sc.nextInt()-1;
		sink = sc.nextInt()-1;
		int answer = 0;
		int flowsent = 1;
		while (flowsent > 0) {
			Arrays.fill(seen, false);
			flowsent = dfs(source, Integer.MAX_VALUE);
			answer += flowsent;
		}
		System.out.println(answer);
	}
	static int dfs(int i, int flow) {
		if (i == sink) return flow;
		seen[i] = true; // flow = min(flow,nodecap[i]);
		for (int j = 0; j < nodes; j++) { // loop through all possible locations I can hit
			if (!seen[j] && cap[i][j] > 0) {
				int hit = dfs(j,Math.min(flow,cap[i][j]));
				if (hit > 0) {
					cap[i][j] -= hit;
					cap[j][i] += hit;
					return hit;
				}
			}
		}
		return 0;
	}
}
