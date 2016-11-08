
public class CatalanNumberGen {
	public static void main(String[] args) {
		int n = 1002;
		long[] s = new long[n];
		long mod = 1000000;
		s[0] = 1;
		s[1] = 1;
		for (int i = 2; i < 1002; i++) {
			for (int j=0; j<i; j++){
				s[i] += (s[j] * s[i-j-1]);
//				s[i]%=mod; MOD incase the values need to be modded.
			}
		}
		for(int i = 0; i <= 10; i++)
			System.out.println(s[i]);
	}
}