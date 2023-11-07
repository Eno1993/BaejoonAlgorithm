import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	Stack<Integer> stack = new Stack<Integer>();
	Queue<String> check = new LinkedList<String>();
	int point=0;
	int s=1; //stack 에 넣어야 할 숫자
	public Main(int arr[],int number) {
		while(point < number) {
			if(stack.empty()) {
				for(; s<=arr[point]; s++) {
					stack.push(s); check.add("+");
				}
			}
			if(stack.peek()==arr[point]) {
				stack.pop(); check.add("-"); point++;	
			}
			else {
				if(arr[point] >= s) { 
					for(; s<=arr[point]; s++) {
						stack.push(s); check.add("+");
					}
				}
				else { break;}
			}
		}
		if(point == number) {
			while(!check.isEmpty()) {
				System.out.println(check.poll());
			}
		}
		else { System.out.print("NO");}
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int arr[] = new int[number];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		Main stack = new Main(arr,number);
	}

}
