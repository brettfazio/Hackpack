// Brett Fazio, basic problem solution template.

import java.util.Scanner;

// You will always need this public class, you can call it whatever though.
public class BasicProblemTemplate {

	// In main is where you write all of your code (you can write it
	// elsewhere but for now write it in main)
	public static void main(String[] args) {
		// Scanner is what you use to scan stuff in (i.e. take input)
		// I called my Scanner "sc" but you can call it whatever you want.
		Scanner sc = new Scanner(System.in);
		
		// I just took an integer in as input.
		int a = sc.nextInt();
		
		// I just scanned in the whole line of input into a string.
		String s = sc.nextLine();
		

		// I just printed the value of a to the console.
		System.out.println(a);
		
		// I just printed the value of s to the console
		System.out.println(s);
		
		// I just printed Hello World! to the console.
		System.out.println("Hello World!");
		
		// This is the same as the print statement above, you can
		// add strings and it becomes a longer string.
		System.out.println("Hello " + " World!");
		
	}

}
