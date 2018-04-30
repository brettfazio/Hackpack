import java.util.*;
import java.io.*;
public class LongerDSU {
    static int[] par, height;
    static ArrayDeque[] set;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt(), m = sc.nextInt(); //n = number of nodes, m = number of edges
        par = new int[n]; //par[i] = parent of node i
        height = new int[n]; //height[i] = size of set that node i belongs to
        set = new ArrayDeque[n]; //set[i] = list of nodes that belong to parent node i
        for(int i = 0; i < n; ++i){
            par[i] = i;
            height[i] = 1;
            set[i] = new ArrayDeque<edge>();
            set[i].push(i); //starts with just itself in its set
        }
        
        PriorityQueue<edge> edges = new PriorityQueue<>(); //scan in edges and make u to be less than v (for (u, v) pairs to be ordered)
        
        PriorityQueue<pair> pairsOut = new PriorityQueue<>(); //stores edges as (u, v) pairs in lexicographical order
        int numConnd = 1; //starts with one node connected
        int out = 0; //cost of spanning tree
        while(!edges.isEmpty()){
            edge curr = edges.poll();
            if(!union(curr.u, curr.v)) continue;
            
            out += curr.w;
            pairsOut.add(new pair(curr.u, curr.v));
            if(++numConnd == n) break; //all nodes are connected
        }
        if(numConnd == n){
            pw.println(out);
            while(!pairsOut.isEmpty()) pw.println(pairsOut.poll());
        }
        else{
            pw.println("Impossible"); //only prints out when not all nodes have been connected
        }
        pw.close();
    }
    static boolean union(int a, int b){
        int parA = par[a]; //gets parent of set that a belongs to
        int parB = par[b];
        if(parA == parB) return false; //these nodes are in the same set
        
        if(height[parA] > height[parB]) parA = parA ^ parB ^ (parB = parA); //since we'll be adding the children of set of parA to the 
                                                                            //set of parB, we make the smaller of the two to be parA
        
        height[parB] += height[parA]; //update size of set of parB
        for(Object temp : set[parA]){
            int curr = (int)temp;
            par[curr] = parB; //make the parent of all nodes in set a to parB
            set[parB].push(curr); //add node to set of parB
        }
        set[parA].clear(); //clear nodes at parA for memory?
        
        return true;
    }
    static class edge implements Comparable<edge>{
        int u, v, w;
        edge(int uIn, int vIn, int wIn){
            u = uIn;
            v = vIn;
            w = wIn;
        }
        public int compareTo(edge in){
            return w - in.w;
        }
    }
    static class pair implements Comparable<pair>{
        int a, b;
        pair(int aIn, int bIn){
            a = aIn;
            b = bIn;
        }
        public int compareTo(pair in){
            if(a - in.a != 0) return a - in.a;
            return b - in.b;
        }
        public String toString(){
            return a + " " + b;
        }
    }
}
