import java.io.*;
import java.util.*;

public class magicSquareOdd {
	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = 4;
		int[][] ms = new int[n][n];
		int val = 1;
		int x = 0, y = n/2-1;
		while(val <= n*n) {
			if(ms[x][y] != 0) {
				if(x != n-1) {
					x++;
				} else {
					x = 0;
				}
				ms[x][y] = val++;
			} else {
				ms[x][y] = val++;
			}
			if(x-1 < 0) {
				x = n-1;
			} else {
				x--;
			}
			if(y == n-1) {
				y = 0;
			} else {
				y++;
			}
		}
		for(int i = 0; i < n; i++)
			for(int j  =0; j < n; j++)
				if(j != n-1) System.out.print(ms[i][j] + " ");
				else System.out.println(ms[i][j]);
	}
}