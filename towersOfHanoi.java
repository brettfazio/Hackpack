// Ahmad Barhamje & Brett Fazio, Towers of Hanoi


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
	
	// formula is for a towers of hanoi with THREE towers (IE Normal)
	// s = stack number (0 = left, 1 = mid, 2 = right)
	// m = move number (0 = initial state)
	// d = disk number (1 = topmost disk)
	// n = total number of disks
	static int stateCalculation(int s, int m, int d, int n) {
		int adder = (n+d+1)%2;
		adder++;
		adder *= (int)Math.floor((m+Math.pow(2, d-1)/Math.pow(2, d)));
		adder = adder % 3;
		
		return adder;
	}
}
