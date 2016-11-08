// Brett Fazio, Kadane's Algoritm, Max range in 1D[]

public class kadanes {

	public static void main(String[] args) {

		int[] arr = {100, 100, 100, -100, -1000};

		int running = 0;
		int max = Integer.MIN_VALUE;
		int l = 0, r = 0;
		int ml = 0, mr = 0;
		for (int i= 0; i < arr.length; i++) {
			running += arr[i];
			r++;



			if (running > max) {
				ml = l;
				mr = r;
				max = running;
			}else {
			}


			if (running < 0) {
				running = 0;
				l = i+1;
			}
		}
		ml++; // for zero basing
		mr++;
		System.out.println(max + " " + ml + " " + mr);
		// ML = Inclusive, MR = Exclusive
	}

}
