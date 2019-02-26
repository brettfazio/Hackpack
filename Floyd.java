class Floyd {
    static int n, m;
    static long inf = Long.MAX_VALUE / 2;
    static long[][] d;
    public static void main (String[] args){
        d = new long[n][n];
        for(int i = 0; i < n; ++i) Arrays.fill(d[i], inf);
        for(int i = 0; i < n; ++i) d[i][i] = 0;
        
        //edges of graph
        for(int i = 0; i < m; ++i){
            int a, b, w;
            if(w < d[a][b]) d[a][b] = d[b][a] = w;
        }
        
        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
