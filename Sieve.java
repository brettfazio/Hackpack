import java.util.*;

public class Sieve {
	public static void main(String[] args) {
		int MAX = 10_000_000;
		boolean[] isPrime = new boolean[MAX];
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;		
		
		// We stop at the square, and don't redivide for composites.
		for (int i=2; i<Math.sqrt(MAX)+1; i++)
			if (isPrime[i])
				for (int j=2*i; j<MAX; j+=i)
					isPrime[j] = false;	
		
		System.out.println(isPrime[16]);
	}
}
