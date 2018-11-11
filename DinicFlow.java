
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Phan
 */
public class dinicstest {
    public static void main(String[] args)
    {
        DinicFlow test = new DinicFlow(5);
        test.addEdge(0, 2, 5);
        test.addEdge(2, 1, 2);
        test.addEdge(2, 4, 4);
        test.addEdge(4, 3, 2);
        test.addEdge(3, 1, 3);
        System.out.println(test.dinic(0, 1));
    }
}

class DinicFlow {
    class Edge {
        int u, v, flow, cap;
        Edge reverseEdge;
        public Edge(int start, int end, int hold) {
            u = start;
            v = end;
            flow = 0;
            cap = hold;
        }
    }

    void addEdge(int u, int v, int cap) {
        Edge addU = new Edge(u, v, cap);
        Edge addV = new Edge(v, u, 0);
        addU.reverseEdge = addV;
        addV.reverseEdge = addU;

        adj[u].add( addU );
        adj[v].add( addV );
    }

    ArrayList<Edge>[] adj;
    int n;
    public DinicFlow(int n) {
        adj = new ArrayList[n];
        this.n = n;
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    int[] level;
    boolean BFS(int source, int sink) {
        level = new int[n];
        Arrays.fill(level, -1);
        level[source] = 0;

        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        bfs.addLast(source);

        while(!bfs.isEmpty()) {
            int now = bfs.pollFirst();

            for(Edge e : adj[now]) {
                if(level[e.v] < 0 && e.flow < e.cap) {
                    level[e.v] = level[now] + 1;
                    bfs.addLast(e.v);
                }
            }
        }

        return level[sink] != -1;
    }

    int getFlow (int at, int flow, int sink, boolean[] blocked) {
        if(at == sink) return flow;

        int totalFlow = 0;
        for(Edge e : adj[at]) {
            if(!blocked[e.v] && level[e.v] == level[at]+1 && e.flow < e.cap) {

                int curFlow = Math.min(flow, e.cap - e.flow);
                int findFlow = getFlow(e.v, curFlow, sink, blocked);

                if(findFlow > 0) {
                    e.flow += findFlow;

                    e.reverseEdge.flow -= findFlow;
                    
                    totalFlow += findFlow;
                }

            }
        }
        blocked[at] = true;

        return totalFlow;
    }

    int dinic (int source, int sink) {
        if(source == sink) return -1;

        int total = 0;

        while(BFS(source, sink)) {
            int addFlow;
            while( (addFlow = getFlow(source, Integer.MAX_VALUE, sink, new boolean[n])) > 0 ) {
                total += addFlow;
            }
        }

        return total;
    }
}
