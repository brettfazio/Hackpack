import java.util.ArrayDeque;

// Brett Fazio, Breadth First Search
// Searches from S -> E, not going over
// the #, only the .

public class BFS {

	static final int[] DD = {-1,1,0,0};
	static final int[] DA = {0,0,1,-1};
	
	public static void main(String[] args) {

		char[][] map = new char[50][50];
		int[][] steps = new int[50][50];
		node start = new node(-1,-1);
		// Find start
		outer : for (int d = 0; d < map.length; d++) {
			for (int a = 0; a < map[d].length; a++) {
				if (map[d][a] == 'S') {
					start = new node(d,a);
					break outer;
				}
			}
		}
		
		// Start is found, now search
		// We are going to record number of moves.
		
		ArrayDeque<node> nodes = new ArrayDeque<>();
		nodes.add(start);
		node end = new node(-1,-1);
		
		outer : while (nodes.isEmpty() == false) {
			node pop = nodes.pollFirst();
			
			for (int type = 0; type < 4; type++) {
				int nd = pop.d + DD[type];
				int na = pop.a + DA[type];
				
				if ( map[nd][na] == 'E') {
					end = new node(nd,na);
					steps[nd][na]= steps[pop.d][pop.a]+1;
					break outer;
				}
				
				if (map[nd][na] == '.') {
					map[nd][na] = '#';
					steps[nd][na] = steps[pop.d][pop.a]+1;
					nodes.add(new node(nd,na));
				}
			}
		}
		
		System.out.println(steps[end.d][end.a]);
	}

}

class node {
	int d,a,steps; // Down, Across
	
	public node(int dd, int aa) {
		d = dd;
		a = aa;
	}
}