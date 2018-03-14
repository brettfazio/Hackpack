//a Trie is a way of storing strings in a tree of character nodes. 
//The method root.getNthNode() gets the nth string in the tree 
import java.io.*;
import java.util.*;

public class Trie{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        Solver solver = new Solver();
        int t = sc.nextInt();
        for(int count = 1; count <= t; count++){
            solver.solve(count, sc, pw);
        }
        sc.close();
        pw.close();
    }
    
    private static class Solver{
        class Node{
            char l;
            boolean terminal = false;
            int size = 0;
            HashMap<Integer, Node> children = new HashMap<>();
            
            Node(int lIn){
                l = (char) (lIn + 'a');
            }
            
            void push(int[] word, int currLet){
                size++;
                
                if(currLet == word.length){
                    terminal = true;
                    return;
                }
                
                if(!children.containsKey(word[currLet])){
                    children.put(word[currLet], new Node(word[currLet]));
                }
                
                children.get(word[currLet]).push(word, currLet + 1);
            }
            
            String getNthNode(int in){
                if(in == 1 && terminal){
                    return "";
                }
                
                int numWordsSeen = terminal ? 1 : 0;
                for(int i : alphOrder){
                    if(!children.containsKey(i)) continue;
                    
                    Node currChild = children.get(i);
                    if(numWordsSeen + currChild.size >= in){
                        return currChild.l + currChild.getNthNode(in - numWordsSeen);
                    }
                    
                    numWordsSeen += currChild.size;
                }
                return "";
            }
        }
        
        void swap(int a, int b){
            int aIndex = -1, bIndex = -1;
            for(int i = 0; i < 26; i++){
                int curr = alphOrder[i];
                if(curr == a) aIndex = i;
                else if(curr == b) bIndex = i;
            }
            alphOrder[aIndex] = alphOrder[bIndex] ^ alphOrder[aIndex] ^ (alphOrder[bIndex] = alphOrder[aIndex]);
        }
        
        int[] alphOrder;
        int n, q;
        Node root;
        
        void solve(int count, Scanner sc, PrintWriter pw){
            alphOrder = new int[26];
            for(int i = 0; i < 26; i++) alphOrder[i] = i;
            
            root = new Node(-1);
            
            n = sc.nextInt();
            q = sc.nextInt();
            
            for(int i = 0; i < n; i++){
                char[] wordIn = sc.next().toCharArray();
                int[] in = new int[wordIn.length];
                for(int j = 0; j < in.length; j++) in[j] = (int) (wordIn[j] - 'a');
                
                root.push(in, 0);
            }
            
            pw.printf("Gift Exchange #%d:%n", count);
            for(int i = 0; i < q; i++){
                if(sc.nextInt() == 1){
                    int a = sc.next().charAt(0) - 'a', b = sc.next().charAt(0) - 'a';
                    swap(a, b);
                }
                else{
                    int in = sc.nextInt();
                    pw.println(root.getNthNode(in));
                }
            }
            pw.println();
        }
    }
}
