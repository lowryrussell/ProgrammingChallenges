import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		String firstPick[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String secondPick[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String temp;
		
		char sep[] = new char[2];
		sep[0] = sep[1] = '\0';
		int shuffles[][] = new int[101][52];
		int orderOfShuffles[] = new int [101];
		int shufflesKnown, shufflesDone, T, pos;
		
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		System.out.println(T);
		
		while (T-- > 0) {
			
			System.out.print(sep);
			sep[0] = '\n';

			shufflesKnown = scanner.nextInt();
			System.out.println(shufflesKnown);
			
			for (int x = 0; x < shufflesKnown; x++) {
				
				for (int y = 0; y < 52; y++) {
					
					shuffles[x][y] = scanner.nextInt();
					shuffles[x][y]--;
				}
			}
			
			shufflesDone = 0;
			int skipLines = T;
			while(skipLines-- > 0) {
				System.out.println(scanner.nextLine());
			}
			temp = scanner.nextLine();
			
			while (!temp.trim().isEmpty()) {
				
				orderOfShuffles[shufflesDone++] = Integer.parseInt(temp) - 1;
				temp = scanner.nextLine();
			}
						
			for (int q = 0; q < 52; q++) {
				
				pos = q;
				for (int y = shufflesDone - 1; y >= 0; y--) {
					pos = shuffles[orderOfShuffles[y]][pos];
				}
				
				System.out.println(firstPick[pos % 13] + " of " + secondPick[pos / 13]);
			}
		}
		
		// TODO Auto-generated method stub

	}

}
