import java.util.*;
public class MinDSingleSource {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt(), m = sc.nextInt(); // n = number of nodes, m = number of edges
	    ArrayDeque[] edges = new ArrayDeque[n]; // at index i, stores all edges that connect to node i
	    
	    for(int i = 0; i < m; i++){
	        int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
	        if(edges[u] == null) edges[u] = new ArrayDeque<edge>();
	        edges[u].add(new edge(v, w));
	    }
	    
	    int source = 0; // source node
	    int[] minDTo = new int[n];
	    Arrays.fill(minDTo, Integer.MAX_VALUE);
	    minDTo[source] = 0;
	    
	    ArrayDeque<Integer> updates = new ArrayDeque<>();
	    updates.add(source);
	    
	    while(!updates.isEmpty()){
	        int u = updates.poll();
	        if(edges[u] == null) continue;
	        for(Object temp : edges[u]){
	            edge curr = (edge)temp;
	            int testD = minDTo[u] + curr.w;
	            if(testD < minDTo[curr.v]){
	                minDTo[curr.v] = testD;
	                updates.add(curr.v);
	            }
	        }
	    }
	    
	    System.out.println(minDTo[2]);
	}
	static class edge{
	    int v, w;
	    edge(int vIn, int wIn){
	        v = vIn;
	        w = wIn;
	    }
	}
}
