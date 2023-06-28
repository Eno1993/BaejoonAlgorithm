import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int wine[] = new int[10001];
		int sum[] = new int[10001];
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		for(int i=0; i<number; i++) {
			wine[i] = s.nextInt();
		}
		sum[0] = wine[0]; 
		sum[1] = wine[0]+wine[1];
		sum[2] = Math.max(Math.max(wine[0]+wine[1],wine[0]+wine[2]), wine[1]+wine[2]);
		for(int i=3; i<number; i++) {
			sum[i] = Math.max(Math.max(sum[i-2]+wine[i],sum[i-3]+wine[i-1]+wine[i]),sum[i-1]);
		}
		System.out.print(sum[number-1]);
	}
}
