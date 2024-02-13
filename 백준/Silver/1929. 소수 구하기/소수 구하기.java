import java.util.Scanner;

public class Main {
	int start,end;
	int arr[];
	int sum;

	public Main(int s, int e) {
		start = s;
		end = e;
		arr = new int[end+1];
	}
	
	public void check() {
		for(int i =2; i<=end; i++) {
			sum = i;
			while(sum<=end) {
				if((start<=sum)&&(arr[sum]==0)) { System.out.println(sum);}
				sum +=i;
				if(sum >end) { break;}
				else{ arr[sum] = 1; }
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int s, e;
		s = scanner.nextInt();
		e = scanner.nextInt();
		Main minority = new Main(s,e);
		minority.check();


	}

}
