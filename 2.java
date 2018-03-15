import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numOfStudents = 0;
		
		numOfStudents = Integer.parseInt(scanner.nextLine());
		do {
			
			int[] totalTripCosts = new int[numOfStudents];
			
			for (int i = 0; i < numOfStudents; i++) {
				
				String line = scanner.nextLine();
				int cents = (Integer.parseInt(line.replace(".","").replace(" ", "")));
				totalTripCosts[i] = cents;
			}

			System.out.printf("$%.2f\n", calcStudentCosts(totalTripCosts));

			numOfStudents = Integer.parseInt(scanner.nextLine().replace(" ", ""));
		} while (numOfStudents != 0); 
		scanner.close();
	}
	
	public static double calcStudentCosts(int[] array) {
		
		int tripAverage = 0;
		int tripRemainder = 0;
		int totalCosts = 0;
		
		int arrayLength = array.length;

		for (int x = 0; x < arrayLength; x++) {
			totalCosts += array[x];
		}
		tripAverage = totalCosts / arrayLength;
		tripRemainder = totalCosts % arrayLength;	
		
		int totalEndingCosts = 0;
		int nBiggerAvg = 0;

		for (int x = 0; x < arrayLength; x++) {
			if (array[x] > tripAverage) {
				totalEndingCosts += array[x] - tripAverage;
				nBiggerAvg++;
			}
		}

		totalEndingCosts -= (Math.min(nBiggerAvg, tripRemainder));
		double finalCost = totalEndingCosts / 100.00;

		return finalCost;
	}
}