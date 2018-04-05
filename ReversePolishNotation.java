import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Iterator;
public class RPN {
  static ArrayDeque<Character> ops, out;
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter pw = new PrintWriter(System.out);
	    char[] in = br.readLine().toCharArray();
	    ops = new ArrayDeque<>();
	    out = new ArrayDeque<>();
	    for(char c : in){
	        if(c == ' ') continue;
	        else if(isOp(c)){
	            switch(c){
	                case '(':
	                    ops.push(c);
	                    break;
	                case ')':
	                    while(weGood()){
	                        out.push(ops.pop());
	                    }
	                    ops.pop();
	                    break;
	                case '+':
	                case '-':
	                    while(weGood()){
	                        out.push(ops.pop());
	                    }
	                    ops.push(c);
	                    break;
	                case '*':
	                case '/':
	                    while(weGood() && notAS()){
	                        out.push(ops.pop());
	                    }
	                    ops.push(c);
	                    break;
	                case '^':
	                    ops.push(c);
	                    break;
	            }
	        }
	        else{
	            out.push(c);
	        }
	    }
	    while(weGood()) out.push(ops.pop());
	    
	    Iterator it = out.descendingIterator();
	    while(it.hasNext()) pw.print(it.next() + " ");
	    
	    pw.println();
	    pw.close();
	}
	static boolean weGood(){
	    return !ops.isEmpty() && ops.peek() != '(';
	}
	static boolean notAS(){
	    return ops.peek() != '+' && ops.peek() != '-';
	}
	static boolean isOp(char in){
	    if(in == '^') return true;
	    if(in == '*') return true;
	    if(in == '/') return true;
	    if(in == '+') return true;
	    if(in == '-') return true;
	    if(in == '(') return true;
	    if(in == ')') return true;
	    return false;
	}
}
