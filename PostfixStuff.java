import java.util.*;

public class PostfixStuff {
	public static void main(String[] args) throws Exception {
		String eq = "4 1 2 9 3 / * + 5 - *";
		double res = postfixCalculator(eq);
		System.out.println(res);
		
		eq = "4 * ( 1 + 2 * ( 9 / 3 ) - 5 )";
		String ret = shuntingYard(eq);
		System.out.println(ret);
	}
	
	//returns an infix expression in postfix notation.
	static String shuntingYard(String eq) {
		String[] split = eq.split("\\s+");
		Stack<String> s = new Stack<>();
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < split.length; i++) {
			if(isNum(split[i])) {
				res.append(split[i] + " ");
			} else {
				switch(split[i]) {
				case ")":
					while(!s.isEmpty()) {
						String now = s.pop();
						if(now.equals("(")) break;
						res.append(now + " ");
					}
					break;
				case "(":
					s.push(split[i]);
					break;
				default:
					int p = precedence(split[i]);
					while(!s.isEmpty()) {
						String str = s.peek();
						int p2 = precedence(str);
						if(p2 >= p) {
							res.append(str + " ");
							s.pop();
						} else break;
					}
					s.push(split[i]);
					break;
				}
			}
		}
		while(!s.isEmpty()) res.append(s.pop() + " ");
		return res.toString().trim();
	}
	
	static int precedence(String s) {
		switch(s) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		}
		return -1;
	}
	
	private static boolean isNum(String string) {
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i)) == false) return false;
		}
		return true;
	}

	//returns the value of a function in Postfix notation
	//String passed must be in postfix notation
	//to evaluate a function in prefix notation, do this method but read the string backwards.
	static double postfixCalculator(String eq) {
		String[] split = eq.split("\\s+");
		Stack<String> s = new Stack<>();
		for(int i = 0; i < split.length; i++) {
			int val;
			if((val = isOperator(split[i])) > 0) {
				double push = 0;
				double n2 = Double.parseDouble(s.pop());
				double n1 = Double.parseDouble(s.pop());
				switch(val) {
				case 1:
					push = n1 + n2;
					break;
				case 2:
					push = n1 / n2;
					break;
				case 3:
					push = n1 * n2;
					break;
				case 4:
					push = n1 - n2;
					break;
				}
				s.push(push + "");
			} else {
				s.push(split[i]);
			}
		}
		return Double.parseDouble(s.pop());
	}

	private static int isOperator(String string) {
		switch(string) {
		case "+":
			return 1;
		case "/":
			return 2;
		case "*":
			return 3;
		case "-":
			return 4;
		}
		return -1;
	}
}