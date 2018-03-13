import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //number of nodes
		int m = scan.nextInt(); //number of edges
		ArrayList[] node = new ArrayList[n];
		boolean[] visited = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 0; i < n; i++) {
			//Initialize your array of ArrayLists
			node[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < m; i++) {
			int n1 = scan.nextInt()-1;
			int n2 = scan.nextInt()-1;
			int w = scan.nextInt();
			node[n1].add(new Edge(n1, n2, w)); //Add edges both ways
			node[n2].add(new Edge(n2, n1, w));
		}
		
		visited[0] = true;
		pq.addAll(node[0]);
		long answer = 0;
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			if(visited[current.node2]) {
				continue; //Skip if Already visited
			}
			
			answer += current.weight;
			visited[current.node2] = true;
			pq.addAll(node[current.node2]);
		}
		System.out.println(answer);

	}
	


}
	class Edge implements Comparable<Edge>{
		public int node1, node2, weight;
		
		public Edge (int n1, int n2, int w) {
			node1 = n1;
			node2 = n2;
			weight = w;
		}
		
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
