//Brett Fazio, Ternanry Search

public class TernarySearch {

	static double xf = 0;
	public static void main(String[] args) {

		double t = ts(1,100);
		
		System.out.println(t +" "+  xf);
		
	}

	static double func(double c) { 
    //(WHAT EVER YOU WANT TO COMPARE)
    return c*c;
	}


	static double ts(double start, double end) {
		double l = start, r = end;

		for(int i=0; i<250; i++) {
			double l1 = (l*2+r)/3;
			double l2 = (l+2*r)/3;
			if(func(l1) < func(l2)) r = l2; else l = l1;
		}

		double x = l;
		xf = x;
		return func(x);
	}

}
