// Math behind
// Permutations and Combinations
public class PermCombinMath {

	public static void main(String[] args) {
		//Permutations
		// number of ways r thing can be taken from a 
		// group of n things (nPr Permutations)
		// Order DOES matter
		int n = 5;//number of elements total
		int r = 2;//number of elements selecting
		
		int nPr = factorial(n) / factorial(n-r);
		
		//Combinations
		// order does NOT matter
		//number of combinations for n things taken r at a time.
		int nCr = factorial(n) / (factorial(n-r)*factorial(r));
	}
	
	public static int factorial(int in) {
		int ret = 1;
		for (int i = 2; i <= in; i++) {
			ret *= i;
		}
		return ret;
	}

}
