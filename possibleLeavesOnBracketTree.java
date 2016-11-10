//How many leaves on a tree
public class monkey 
{
	/*
	* Code for contest monkey.java
	* Input of:
1
[[][[[][[][[][[][[[][[[[][[][[[[[][[[][[[[[[[][]][]][]][]][]][]]][]]][]][]][]]]][]][]]][]]]]]][]]]
	* Outputs:
1 33554432	
	*/
	public static void main (String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		
		int cases = stdin.nextInt();
		stdin.nextLine();
		
		for (int count=0; count<cases; count++)
		{
			String next = stdin.nextLine();

			int val = 1;
			int curDep = 0;
			int temp = 0;
			//Find the max depth
			for(int i=0; i<next.length();i++)
			{
				if(next.charAt(i)=='[')
					curDep++;
				else
					curDep--;
				if(curDep > temp)
					temp = curDep;
			}
			//2 ^ max depth
			val = (int) Math.pow(2, temp);
			System.out.println((count+1) +" "+ val);
		}
		stdin.close();
	}
}
