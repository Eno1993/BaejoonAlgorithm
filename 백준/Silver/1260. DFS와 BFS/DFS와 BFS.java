import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	int arr[][]; 
	int N, M, V;
	int Dcheck[];
	int Bcheck[];
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public Main(int n, int m, int v) {
		arr = new int[n+1][n+1]; N = n; M = m; V= v;
		Dcheck = new int[n+1];
		Bcheck = new int[n+1];
	}
	public void push(int a,int b) {
		arr[a][b] = 1;
		arr[b][a] = 1;
	}
	
	public void dfs(int V) {
		Dcheck[V] = 1;
		System.out.print(V+" ");
		for(int i=0; i<=N; i++) {
			if(arr[V][i]==1) {
				if(Dcheck[i]==0) {
					dfs(i);
				}
			} 
		}
	}
	public void bfs(int V) {
		queue.offer(V);
		Bcheck[V] = 1;
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v+" ");
			for(int i =0; i<=N; i++) {
				if(arr[v][i] == 1) {
					if(Bcheck[i]==0) {
						queue.offer(i);
						Bcheck[i] = 1;
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in); 
		  Main main = new Main(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()); 
		  for(int i=0; i<main.M; i++) {
			  main.push(scanner.nextInt(),scanner.nextInt());
		  }
		  main.dfs(main.V);
		  System.out.println();
		  main.bfs(main.V);
		
		/*
		 * for(int i=0; i<main.N+1; i++) { for(int j=0; j<main.N+1; j++) {
		 * System.out.print(main.arr[i][j]); } System.out.println(); }
		 */

		 
		
	}

}
