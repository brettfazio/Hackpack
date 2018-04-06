class LCS {
    static char[] lets = {'a', 'b', 'c', 'd'};
	public static void main (String[] args){
        String a = "adbcdabdca", b = "adbcadbbacd";
	    System.out.println(lcs(a, b));
	}
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
