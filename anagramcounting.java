import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class anagramcounting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while (sc.hasNext()) {
			
			String in = sc.nextLine();
			
			int[] cnt = new int[26*2];
			
			for (int i = 0 ; i < in.length(); i++) {
				
				char curr = in.charAt(i);
				
				if (curr >='a' && curr <='z') {
					cnt[curr-'a']++;
				}
				if (curr >='A' && curr <='Z') {
					cnt[curr-'A'+26]++;
				}
				
			}
			
			
			BigInteger b  = new BigInteger("1");
			int stack = 1;
			for (int i =0 ; i < cnt.length; i++) {
				if (cnt[i] != 0) {
					
					
					BigInteger fact2 = new BigInteger("1");
					for (int j = 1; j <= cnt[i]; j++) {
						b = b.multiply(new BigInteger(stack+""));
						stack++;
						fact2 = fact2.multiply(new BigInteger(j+""));
						
					}
					b = b.divide(fact2);
				}
			}
			
			System.out.println(b);
		}
	}

}
