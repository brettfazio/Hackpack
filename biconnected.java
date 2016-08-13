// Brett Fazio, Biconnected Component Detection
// Lowlink detection, bridge detection, for an undirected graph
// Ceil(bridges/2.0) is the number of edges needed to ensure a path
// back to any node if a edge were to be removed.

import java.util.*;

public class biconnected {

	static boolean used[], art[], bridge[], visited[];
	static int prenumber[], lowlink[];
	static ArrayDeque<Edge>[] adj;
	static int idcount = 0, M, bridges = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt(), edges = sc.nextInt();
		
		used = new boolean[edges];
		bridge = new boolean[edges];
		prenumber = new int[nodes];
		lowlink = new int[nodes];
		adj = new ArrayDeque[nodes];
		art = new boolean[nodes];
		
		M = edges;
		
		Arrays.fill(prenumber, -1);

		for (int i = 0; i < nodes; i++)
			adj[i] = new ArrayDeque<Edge>();
		
		for (int i = 0; i < edges; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			adj[a].add(new Edge(b,i));
			adj[b].add(new Edge(a,i));
		}

		dfs(0,0,M);
		visited = new boolean[nodes];
		Arrays.fill(used, false);
		for (int i = 0; i < nodes; i++) {
			if (visited[i]) continue;
			dfsBridges(i,M);
			if (bridges == 1) {
				// increment a counter
			}
			bridges = 0;
		}
	}
	public static void dfsBridges(int i, int edgeid) {
		visited[i] = true;
		for (Edge e : adj[i]) {
			if (lowlink[e.j] > prenumber[i] || bridge[e.id]) {
				bridge[e.id] = true;
				bridges++;
			}
			if (!used[e.id]) {
				used[e.id] = true;
				
				if (!visited[e.j] && !(lowlink[e.j] > prenumber[i] || bridge[e.id]))
					dfsBridges(e.j, e.id);
			}
		}
	}
	public static int dfs(int i, int parent, int edgeid) {
		if (prenumber[i] != -1) { // this is a back edge
			lowlink[parent] = Math.min(lowlink[parent], prenumber[i]);
			return lowlink[parent]; // returns a lowlink value if it is a backedge
		}
		prenumber[i] = lowlink[i] = idcount++;
		boolean haspath = false;
		for (Edge e : adj[i]) {
			if (!used[e.id]) {
				used[e.id] = true;
				if (dfs(e.j, i, e.id) < 0)
				{
				    lowlink[i] = Math.min(lowlink[i], lowlink[e.j]);
					if (edgeid == M ? haspath : lowlink[e.j] >= prenumber[i]) {
						art[i] = true; // this is an articulation point
					}
					haspath = true;
				}
			}
		}
		return -1;
	}
}
class Edge {
	int j; int id;	
	public Edge(int j, int id) {
		this.j = j;
		this.id = id;
	}
}