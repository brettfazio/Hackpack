/*
Don't use the other bad TowersOfHanois.
They're bad.
*/
import java.util.Scanner;
public class EvenBetterTowersOfHanoi {
	static String[][][] dp = new String[1_000_000]['Z'+1]['Z'+1]['Z'+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(solve(n, 'A', 'B', 'C'));
	}
	static String solve(int n, char start, char medium, char end){
		if(dp[n][start][medium][end] != null) return dp[n][start][medium][end];
		if(n == 1){
			return dp[n][start][medium][end] = start + "->" + end + "\n";
		}
		else{
			dp[n][start][medium][end] = solve(n - 1, start, end, medium);
			dp[n][start][medium][end] += start + "->" + end + "\n";
			dp[n][start][medium][end] += solve(n - 1, medium, start, end);
			return dp[n][start][medium][end];
		}
	}
}
