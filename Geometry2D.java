public class Geometry2D {

    //try and avoid using doubles as often as possible.
    //If dividing, attempt to do integer division if applicable.

    public static final double EPS = 1e-9;

    class Point implements Comparable<Point> {
       double X, Y;

        public Point() {
            X = Y = Integer.MAX_VALUE;
        }

        public Point(int a, int b) {
            X = a; Y = b;
        }
        public Point(double a, double b) {
            X = a; Y = b;
        }

        public int compareTo(Point o) {
            if(equal(X, o.X) && equals(o.Y)) return 0;
            if(!equal(X, o.X)) {
                //smaller X
                if(X < o.X) return -1;
                else return 1;
            } else {
                //smaller Y
                if(Y < o.Y) return -1;
                return 1;
            }
        }

        public double distance(Point b) {
            return Math.hypot(X - b.X, Y - b.Y);
        }

        public Point rotate(Point b, double theta) {
            Point res = new Point();
            double radian = Math.toRadians(theta);
            double nx = X - b.X, ny = Y - b.Y;
            res.X = nx * Math.cos(radian) - ny * Math.sin(radian);
            res.Y = nx * Math.sin(radian) - ny * Math.cos(radian);
            return res;
        }
    }

    class Line {
        //A line is defined by the equation ax + by + c = 0
        //b = 0 for vertical lines otherwise b = 1
        double a, b, c;
        public Line(double A, double B, double C) {
            a = A; b = B; c = C;
        }
        public Line() {}

        public void pointsToLine(Point p1, Point p2) {
            if(equal(p1.X, p2.X)) {
                //vertical line
                a = 1.0; b = 0.0; c = -p1.X;
            } else {
                a = -(double)(p1.Y - p2.Y) / (p1.X - p2.X);
                b = 1.0;
                c = -(double)(a * p1.X) - p1.Y;
            }
        }

        public boolean parallel(Line l) {
            if(equal(a, l.a) && equal(b, l.b)) return true;
            return false;
        }

        public boolean same(Line l) {
            return parallel(l) && equal(c, l.c);
        }
    }

    class Vector {
        double x, y;
        public Vector(double a, double b) {
            x = a; y = b;
        }

        public Vector scale(Vector v, double s) {
            //s >= 0
            return new Vector(v.x * s, v.y * s);
        }
    }

    public double dotProduct(Vector a, Vector b) {
        return a.x * b.x + a.y * b.y;
    }

    public double normSq(Vector v) {
        return v.x * v.x + v.y * v.y;
    }

    public double distToLine(Point p, Point a, Point b) {
        //returns the distance between a point p and the line defined by a and b.
        //formula: c = a + u * ab
        Vector ap = toVector(a, p), ab = toVector(a, b);
        double u = dotProduct(ap, ab) / normSq(ab);
        Point c = translate(a, ab.scale(ab, u));
        return c.distance(p);
    }

    public double distToLineSegment(Point p, Point a, Point b) {
        Vector ap = toVector(a, p), ab = toVector(a, b);
        double u = dotProduct(ap, ab) / normSq(ab);
        if(u < 0.0) {
            return p.distance(a);
        } else if(u > 1.0) {
            return p.distance(b);
        }
        return distToLine(p, a, b);
    }

    public Point translate(Point p, Vector v) {
        return new Point(p.X + v.x, p.Y + v.y);
    }

    public Vector toVector(Point a, Point b) {
        return new Vector(b.X-a.X, b.Y-a.Y);
    }

    public boolean equal(double x1, double x2) {
        return Math.abs(x1-x2) <= EPS;
    }

    public Point intersection(Line o, Line t) {
        if(o.parallel(t)) return null;
        Point res = new Point();
        res.X = (t.b * o.c - o.b * t.c) / (t.a * o.b - o.a * t.b);
        //avoid division by 0
        if(o.b > EPS) res.Y = -(o.a * res.X + + o.c);
        else res.Y = -(t.a * res.X + t.c);
        return res;
    }

    public void test() {
        Point a = new Point(0, 0), b = new Point(0, 10), c = new Point(5.0, 2.5);
        double d = distToLineSegment(c, a, b);
        System.out.printf("%G\n", d);
    }

    public static void main(String[] args) throws Exception {
        //Tested and worked
        Geometry2D test = new Geometry2D();
        test.test();
    }
}