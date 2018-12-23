public class AreaOfPolygon {

	public static void main(String[] args) {
		
		int n = 5;
		
		double[] x = new double[n];
		double[] y = new double[n];
		
		double adder = 0;
		
        	// Calculate value of shoelace formula 
	        int j = n - 1; 
        	for (int i = 0; i < n; i++) 
        	{ 
			adder += (X[j] + X[i]) * (Y[j] - Y[i]); 
			j = i;  
        	} 
      
		adder = Math.abs(adder/2.0);
		
		double res = adder;
		
	}

}
