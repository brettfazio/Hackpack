import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class EulerianGraph {

    /*

    For undirected graphs.

    A Eulerian Path is a traversal of a graph in which we visit all edges exactly once.
    1) For there to be a Eulerian Path, all vertices with a non-zero degree must be connected.
    2) There must be either 0 or 2 vertices with an odd degree.

    A graph with a Eulerian Circuit is a traversal of a graph such that all
    edges have been visited exactly once and the start and end vertices are the same.
    Notice that if a connected component of a graph has a Eulerian circuit, then we can start
    at any node.
    For there to be a Eulerian Circuit, the first condition above still applies but all vertices
    must have an even degree.

     */

    ArrayList<Integer>[] adj;
    int n;

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public EulerianGraph(int N) {
        n = N;
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    }

    public void dfs(int at, boolean[] V) {
        for(Integer i : adj[at]) {
            if(!V[i]) {
                V[i] = true;
                dfs(i, V);
            }
        }
    }

    public boolean connected() {
        boolean[] V = new boolean[n];

        int at = -1;
        for(int i = 0; i < n; i++) {
            if(!adj[i].isEmpty()) {
                at = i;
                break;
            }
        }

        if(at == -1) {
            //no edges
            return true;
        }

        V[at] = true;
        dfs(at, V);

        for(int i = 0; i < n; i++) {
            if(!adj[i].isEmpty() && !V[i]) return false;
        }
        return true;
    }

    public int isEulerian() {
        //returns 0 if it isn't Eulerian.
        //returns 1 if the graph has a euler path
        //returns 2 if the graph has a euler circuit.

        if(!connected()) return 0;

        int odd = 0;
        for(int i = 0; i < n; i++) {
            if(adj[i].size()%2 == 1) odd++;
        }

        if(odd > 2) return 0;

        //In an undirected graph, the sum of all degrees will be even so there can never
        //be only one edge with an odd degree.

        return odd == 2 ? 1 : 2;
    }

    public static void main(String[] args) throws Exception {
        //Tested and worked
    }
}