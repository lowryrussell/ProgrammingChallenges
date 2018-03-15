import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public static int TOTAL_MINUTES = 480; //8 hours * 60 minutes in each hour

	public static void main(String[] args) throws IOException {
		
		int input;
		int day = 1;
		
		Boolean isValid[] = new Boolean[TOTAL_MINUTES + 2];
		isValid[TOTAL_MINUTES + 1] = false;
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
				
		String newInput;
		
		while((newInput = scanner.readLine()) != null && newInput.length() != 0) {

			input = Integer.parseInt(newInput);
			
			for(int x = 0; x <= 480; x++) {
				
				isValid[x] = true;
			}
			
			int startHour, startMinute, endHour, endMinute;
			int startTime, endTime;
			int bestStartTime = 0, bestLength = 0;
			
			while(input-- > 0) {
				
				String line[] = scanner.readLine().split(" ");
				
				//System.out.println(line[0] + " " + line[1]);
				String parts[] = line[0].split(":");
				startHour = Integer.parseInt(parts[0]);
				startMinute = Integer.parseInt(parts[1]);
				
				String parts1[] = line[1].split(":");
				endHour = Integer.parseInt(parts1[0]);
				endMinute = Integer.parseInt(parts1[1]);
								
				startTime = (startHour - 10) * 60 + startMinute;
				endTime = (endHour - 10) * 60 + endMinute;
				
				for(int x = startTime; x < endTime; x++) {
					
					isValid[x] = false;
				}
			}
				
			for(int x = 0; x <= TOTAL_MINUTES; x++) {
				
				if(isValid[x]) {
					
					int j = x + 1;
					
					while(isValid[j]) {

						j++;
					}
					
					if(j == 480 + 1) {
						
						j--;
					}
					
					if(j - x > bestLength) {
						
						bestStartTime = x;
						bestLength = j - x;
					}
					
					x = j;
				}
			}
			
			printDays(day++, bestStartTime, bestLength);
		}
		return;
	}
	
	public static void printDays(int day, int bestStartTime, int bestLength) {
		
		if(bestLength >= 60) {
			
			String formattedString = String.format("Day #%d: the longest nap starts at %d:%02d and will last for %d hours and %d minutes.", day++, bestStartTime / 60 + 10, bestStartTime % 60, bestLength / 60, bestLength % 60);
			System.out.println(formattedString);
		}
		else {
			String formattedString = String.format("Day #%d: the longest nap starts at %d:%02d and will last for %d minutes.", day++, bestStartTime / 60 + 10, bestStartTime % 60, bestLength);
			System.out.println(formattedString);
		}
	}
}
