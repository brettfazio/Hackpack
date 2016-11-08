
public class towersOfHanoi {
	public static void main(String[] args) {
		//takes 2^n - 1 moves to solve a tower of hanoi with n disks.
		solve(3, 'A', 'B', 'C');
	}
	
	static void solve(int count, char s, char d, char i) {
		if(count == 1) {
			System.out.printf("Move top disc from pole %c to pole %c\n", s, d);
		} else {
			solve(count-1, s, i, d);
			solve(1, s, d, i);
			solve(count-1, i, d, s);
		}
	}
}