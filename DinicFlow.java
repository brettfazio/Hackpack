public class DinicFlow {
    class Edge {
        int u, v, flow, cap, reverseEdge;
        public Edge(int start, int end, int hold) {
            u = start;
            v = end;
            flow = 0;
            cap = hold;
        }
    }

    void addEdge(int u, int v, int cap) {
        Edge addU = new Edge(u, v, cap);
        addU.reverseEdge = adj[v].size();
        Edge addV = new Edge(v, u, 0);
        addV.reverseEdge = adj[u].size();

        adj[u].add( addU );
        adj[v].add( addV );
    }

    ArrayList<Edge>[] adj;
    int n;
    public dinicFlow(int n) {
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

    int getFlow (int at, int flow, int sink) {
        if(at == sink) return flow;

        for(Edge e : adj[at]) {
            if(level[e.v] == level[at]+1 && e.flow < e.cap) {

                int curFlow = Math.min(flow, e.cap - e.flow);
                int findFlow = getFlow(e.v, curFlow, sink);

                if(findFlow > 0) {
                    e.flow += findFlow;

                    adj[e.v].get(e.reverseEdge).flow -= findFlow;

                    return findFlow;
                }

            }
        }

        return 0;
    }

    int dinic (int source, int sink) {
        if(source == sink) return -1;

        int total = 0;

        while(BFS(source, sink)) {
            int addFlow;
            while( (addFlow = getFlow(source, Integer.MAX_VALUE, sink)) > 0 ) {
                total += addFlow;
            }
        }

        return total;
    }
}
