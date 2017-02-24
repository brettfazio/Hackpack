import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class MinimumEditDistanceDP {

    /*
    This dp algorithm will tell you the minimum number of moves to convert one string to another
    if the operations allowed are inserting a character, changing a character, and deleting a character.
     */

    public int minimumEdit(String one, String two) {
        int n = one.length(), m = two.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= n; i++)
            dp[0][i] = i;
        for(int i = 1; i <= m; i++)
            dp[i][0] = i;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char o = two.charAt(i-1), t = one.charAt(j-1);
                if(o == t) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) throws Exception {
        //Tested and worked
    }
}