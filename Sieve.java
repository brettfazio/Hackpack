import java.util.*;

public class Sieve {
	public static void main(String[] args) {
		int max = 10_000_001;
		boolean[] isPrime = new boolean[max];
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		// We stop at the square, and don't redivide for composites.
		for(int i = 2; i < Math.sqrt(max) + 1; i++){
			if(isPrime[i]){
				for(int j = i * 2; j < max; j += i){
					isPrime[j] = false;
				}
			}
		}
		
		System.out.println(isPrime[16]);
	}
}
