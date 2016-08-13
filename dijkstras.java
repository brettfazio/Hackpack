// Brett Fazio, Dijkstra's Shortest Path, N^2 time
// Find all the nodes distances from the source

import java.util.*;

public class dijkstras {

	static boolean[] shortSet;
	static int[][] weight;
	static int[] distance;
	static int current, nodes, edges;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nodes = sc.nextInt();
		edges = sc.nextInt();
		
		int start = sc.nextInt()-1;
		
		weight = new int[nodes][nodes]; shortSet = new boolean[nodes];
		distance = new int[nodes];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for (int i = 0; i < nodes; i++)
			for (int j = 0; j < nodes; j++)
				weight[i][j] = Integer.MAX_VALUE;
		
		for (int i = 0; i < edges; i++) {
			int a = sc.nextInt()-1; int b = sc.nextInt()-1;
			int w = sc.nextInt();
			weight[a][b] = weight[b][a] = w;
		}
		current = start;
		
		for (int i =0 ; i < nodes-1; i++) {
			int u = minDistance();
			shortSet[u] = true;
			
			for (int v = 0; v < nodes; v++) {
				if (!shortSet[v] && weight[u][v] != Integer.MAX_VALUE 
						&& distance[u]+weight[u][v] < distance[v]) 
					distance[v] = distance[u] + weight[u][v];
			}
		}
		
		// Distance will now contain the distances all the nodes have
		// from the source node.
		
		System.out.println(Arrays.toString(distance));
		
	}
	
	public static int minDistance() {
		int min = Integer.MAX_VALUE;
		int mini = -1;
		
		for (int v = 0; v < nodes; v++) {
			if (!shortSet[v] && distance[v] <= min) {
				min = distance[v];
				mini = v;
			}
		}
		
		return mini;
	}

}