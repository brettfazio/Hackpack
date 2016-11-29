import java.io.*;
import java.util.*;

public class LongestZigZag {
	static int longestZigZag(int[] a) {
		int decreasing = 1;
		int increasing = 1;
		for(int i = 1; i < a.length; i++) {
			if(a[i] > a[i-1]) {
				increasing = decreasing+1;
			} else if(a[i] < a[i-1]) {
				decreasing = increasing+1;
			}
		}
		return Math.max(increasing, decreasing);
	}
}