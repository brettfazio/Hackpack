public class AreaOfPolygon {

	public static void main(String[] args) {
		
		int NUM = 5;
		
		double[] x = new double[NUM];
		double[] y = new double[NUM];
		
		double adder = 0;
		
		for (int i = 0; i < NUM; i++) {
			if (i == NUM-1) {
				adder += x[i] * y[0];
				adder += y[i] * x[0];
			}else {
				adder += x[i] * y[i+1];
				adder += y[i] * x[i+1];
			}
		}
		
		adder /= 2.0;
		
		double res = adder;
		
	}

}
