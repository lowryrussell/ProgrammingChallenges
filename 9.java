import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int arr[];
		int a, c, answer;
		
		Scanner scanner = new Scanner(System.in);
		
		a = scanner.nextInt();
		
		while(a-- > 0) {
			
			arr = new int[scanner.nextInt()];
			
			for(int x = 0; x < arr.length; x++) {
				
				arr[x] = scanner.nextInt();
			}
			
			Arrays.sort(arr);
			c = arr[arr.length / 2];
			
			answer = 0;
			for(int x = 0; x < arr.length; x++) {
				
				answer += Math.abs(arr[x] - c);
			}
			
			System.out.println(answer);
		}
		// TODO Auto-generated method stub

	}

}
