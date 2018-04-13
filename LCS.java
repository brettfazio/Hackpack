class LCS {
    static char[] lets = {'a', 'b', 'c', 'd'};
	public static void main (String[] args){
		
        String first = "adbcdabdca", second = "adbcadbbacd";
        
		int[][] dp = new int[first.length()+1][second.length()+1];
		// fast iterative
		for (int a = 0; a  <=first.length(); a++) {
			for (int b = 0; b <= second.length(); b++) {
				if (a == 0 || b == 0) {
					dp[a][b] = 0;
				}else if (first.charAt(a-1)==second.charAt(b-1)) {
					dp[a][b] = dp[a-1][b-1]+1;
				}else {
					dp[a][b] = Math.max(dp[a-1][b], dp[a][b-1]);
				}
			}
		}
        
	}
	// slow recursive
    static int lcs(String a, String b){
        int out = 0;
	    for(char test : lets){
	        int aI = a.indexOf(test);
	        if(aI == -1) continue;
	        int bI = b.indexOf(test);
	        if(bI == -1) continue;
	        int curr = 1;
	        if(aI != a.length() - 1 && bI != b.length() - 1){
	            curr += lcs(a.substring(aI + 1), b.substring(bI + 1));
	        }
	        out = Integer.max(out, curr);
	    }
	    return out;
	}
}
