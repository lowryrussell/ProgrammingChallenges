import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = "", correctAnswer = "";
		int solutionRuns = 1;
		while(scanner.hasNextInt()) {
			
			int numberOfInputs = scanner.nextInt();
			
			if(numberOfInputs == 0) {
				System.exit(0);
			}
			
			scanner.nextLine();
			correctAnswer = "";
			for(int i = 0; i < numberOfInputs; i++) {
				correctAnswer += scanner.nextLine() + "\n";
			}
			
			int inputLineCount = scanner.nextInt();
			scanner.nextLine();
			input = "";
			for(int i = 0; i < inputLineCount; i++) {
				input += scanner.nextLine() + "\n";
			}
			
			//remove all integers from 0-9
			String correct = correctAnswer.replaceAll("[^0-9]+", "");
			String inputted = input.replaceAll("[^0-9]+", "");

			System.out.print("Run #" + solutionRuns + ": ");
			
			if(correctAnswer.equals(input)) {
				System.out.println("Accepted");
			}
			else if(correct.equals(inputted)) {
				System.out.println("Presentation Error");
			}
			else {
				System.out.println("Wrong Answer");
			}
			
			solutionRuns++;
		}
		// TODO Auto-generated method stub

	}

}
