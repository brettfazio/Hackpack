// Brett Fazio, floyd warshall

import java.util.*;

public class Floyd {
   	public static void main(String[] args) {
   		// By default the min value is any number higher than the max value of the input
   		Scanner sc = new Scanner(System.in);
   		int nodes = sc.nextInt(), edges = sc.nextInt();
   		// depending on bidirectionality dp[i][j] may or may not equal dp[j][i]
   		// the code below is bidirectional

   		int[][] dp = new int[nodes][nodes];
   		
   		for (int i = 0; i < dp.length; i++) {
   			Arrays.fill(dp[i], 10000000);
   		}
   		for (int i = 0; i < dp.length; i++)
   			for (int j = 0; j < dp.length; j++)
   				dp[i][j] = i == j ? 0 : dp[i][j];
   		
   		for (int i = 0; i < edges; i++) {
   			int a = sc.nextInt(), b = sc.nextInt(), weight = sc.nextInt();
   			dp[a][b] = dp[b][a] = weight;
   		}
   		for (int k = 0; k < nodes; k++) {
			for (int i = 0; i < nodes; i++) { // i
				for (int j = 0; j < nodes; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
  	}
}
