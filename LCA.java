// Brett Fazio, LCA (Least Common Ancestor)

public class LCA {

	public static void main(String[] args) {
		int a = 12;
		int b = 15;
		
		while (a != b) {
			while (a > b) {
				a /= 2;
			}
			while (b > a) {
				b /= 2;
			}
		}
		System.out.println(a);
	}

}
