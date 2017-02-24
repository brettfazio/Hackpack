import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class BellmanFord {

    /*
    Bellman Ford will find all the shortest paths from a single source when there are negative
    edge weights present. This runs slower than Dijkstra but can handle the negative edge
    weights. Runtime is O(VE).

    Note that running Bellman Ford on a graph with a negative weight cycle will not work
    (cause you can just infinitely take the negative cycle) and this will detect if there is
    one (the way it works is after calculating all distances, if we can find a shorter distance
    after that, then there's a negative weight cycle).

    Also note that if the graph is not a single connected component, then there will obviously
    be weights that are still equal to oo.
     */

    static class Edge {
        int u, v;
        long we;
        public Edge(int a, int b, long w) {
            u = a; v = b; we = w;
        }
    }

    int V, E;
    boolean hasNegativeCycle;
    Edge[] e;

    public BellmanFord(int n, Edge[] abc) {
        E = abc.length;
        V = n;
        e = new Edge[E];
        hasNegativeCycle = false;
        for(int i = 0; i < E; i++) {
            e[i] = abc[i];
        }
    }

    public long[] run(int s) {
        long[] dist = new long[V];
        long oo = (long)2e9;
        Arrays.fill(dist, oo);
        dist[s] = 0;

        for(int i = 1; i < V; i++) {
            for(int j = 0; j < E; j++) {
                if(dist[e[j].u] == oo) continue;
                long check = e[j].we + dist[e[j].u];
                if(dist[e[j].v] > check) {
                    dist[e[j].v] = check;
                }
            }
        }

        //negative weight cycle?
        for(int i = 0; i < E; i++) {
            if(dist[e[i].u] == oo) continue;
            long check = e[i].we + dist[e[i].u];
            if(dist[e[i].v] > check) {
                hasNegativeCycle = true;
            }
        }

        return dist;
    }


    public static void main(String[] args) throws Exception {
        //Tested and worked
    }
}