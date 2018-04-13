// Brett Fazio, binary search

import java.util.*;

public class BinarySearch {

	static int min,max,find;
	static int[] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		min = sc.nextInt();max = sc.nextInt();find = sc.nextInt();
		
		int steps = findInRange((max-min)/2+min,0);
		
		System.out.println("Took " + steps + " to find in range");
		
		array = new int[]{1,3,4,6,7,8,10,15};
		
		int value = sc.nextInt();
		int index = findInArray(value);
		
		System.out.println("The value " + value + " is a position " + index);
	}

	private static int findInRange(int current, int steps) {
		if (current == find) return steps;
		if (current < find) {
			min = current+1;
			int f = findInRange((max-min)/2+min,steps+1);
			if (f != -1) {
				return f;
			}
		}
		if (current > find) {
			max = current-1;
			int f = findInRange((max-min)/2+min,steps+1);
			if (f != -1) {
				return f;
			}
		}
		
		return -1;
	}
	
	private static int findInArray(int find) {
		int low = 0;
		int high = array.length-1;
		int index = -1;
		while (low <= high) {
			int mid = low + (high-low)/2;
			
			if (find < array[mid]) high = mid-1;
			else if (find > array[mid]) low = mid+1;
			else { index = mid; break; }
		}
		return index;
	}
}
