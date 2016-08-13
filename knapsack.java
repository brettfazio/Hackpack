// Brett Fazio, knapsack

import java.util.*;

public class knapsack {

	public static void main(String[] args) {

		int[] weights = {3,2,5,1,6};
		int[] values = {10,6,13,2,15};
		int[] res = knapsack(weights, values, 10);
		
		System.out.println(Arrays.toString(res));
	}

	// Returns true if some subset of array adds up exactly to target.
	public static int[] knapsack(int[] weights, int[] values, int maxWeight) {

		int[] dp = new int[maxWeight+1];

		for (int i=0; i<weights.length; i++)
			for (int j=maxWeight; j>=weights[i]; j--)
				if (dp[j-weights[i]] + values[i] > dp[j])
					dp[j] = dp[j-weights[i]] + values[i];

		// Value we are interested in.
		return dp;
	}
}