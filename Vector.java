class Vector {
	double a,b;
	double c,d;
	double beta;
	
	public Vector(double x1, double y1, double x2, double y2) {
		a = x1;
		b = y1;
		c = x2-x1;
		d = y2-y1;
	}
	
	public Pair intersection(Vector o) {
		Pair ret = new Pair(0,0);
		//x
		double xconst = o.a - a;
		double xmybeta = c;
		double xobeta = -1*o.c;
		//y
		double yconst = o.b - b;
		double ymybeta = d;
		double yobeta = -1*o.d;

		double top = xconst * yobeta - yconst * xobeta;
		double bot = xmybeta * yobeta - xobeta * ymybeta;
		double div = top / bot;

		ret = new Pair(a + (div*c), b + (div*d));
		
		return ret;
	}
	
	public String toString() {
		return "Vector (a b c d) = " + a + " " + b + " " + c + " " + d;
	}
}

class Pair {
	double x, y;
	
	public Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}
}