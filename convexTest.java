import java.util.*;

// Brett Fazio, test whether or not a simple
// polygon is convex. Returns 0 if NOT CONVEX
// Returns 1 if STRICTLY CONVEX
// Returns 2 if CONVEX BUT POINTS ARE UNNECESSARY
// DOES NOT WORK if polygon is self-interesecting


public class convexTest {

	static final double EPS = 1e-9; // too big/small?
	
	static int isConvex(ArrayList<PT> v) {
		int j, k;
		int c1 = 0, c2 = 0, c0 = 0;
		int n = v.size();
		
		for (int i = 0; i < n; i++) {
			j = (i+1)%n;
			k = (j+1)%n;
			int s= sideSign(v.get(i),v.get(j),v.get(k));
			if (s == 0) {
				c0++;
			}
			if (s > 0) {
				c1++;
			}
			if (s < 0) {
				c2++;
			}
		}
		if (c1 != 0 && c2 != 0) {
			return 0;
		}
		if (c0 != 0) {
			return 2;
		}
		return 1;
	}
 	
	static int sideSign(PT p1, PT p2, PT p3) {
		double sg = (p1.x-p3.x)*(p2.y-p3.y)-(p1.x-p3.x)*(p2.y-p3.y);
		if (Math.abs(sg) < EPS) {
			return 0;
		}
		if (sg > 0) {
			return 1;
		}
		return -1;
	}

}

class PT {
	int x, y;
	
	public PT (int xx, int yy) {
		x = xx;
		y = yy;
	}
}
