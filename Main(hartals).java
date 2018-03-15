import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int T, N, P;
		int a[] = new int[100];
		
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		
		while(T-- > 0) {
			
			N = scanner.nextInt();
			P = scanner.nextInt();

			
			int ans = 0;
			
			for (int i = 0; i < P; i++) {
				
				a[i] = scanner.nextInt();
			}
			
			for (int i = 1; i <= N; i++) {
				
				if (i % 7 == 6 || i % 7 == 0) {
					
					continue;
				}
				boolean found = false;
				
				for (int z = 0; z < P; z++) {
					
					if (i % a[z] == 0) {
						found = true;
					}
				}
				if (found) {
					
					ans++;
				}
			}
			System.out.println(ans);
		}
		scanner.close();
	}

}
