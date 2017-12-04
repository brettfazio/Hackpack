// Brett Fazio
// File In/Out for USACO

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class USACOFileInOut {

	public static void main(String[] args) throws FileNotFoundException {

		BufferedReader bu = new BufferedReader(new FileReader(new File("name.in")));
		PrintWriter out = new PrintWriter(new File("name.out"));		

	}
}