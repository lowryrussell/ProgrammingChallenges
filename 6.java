import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean scannerEntered = false;
		
		while(!scannerEntered) {

			if(scanner.hasNext()) {
				scannerEntered = true;
			}
		}
		
		while(scanner.hasNext()) {
			
			String scannerString = scanner.nextLine().toUpperCase().toString();
			char[] scannerCharArray = scannerString.toCharArray();
					
			for(int x = 0; x < scannerCharArray.length; x++) {
				
				if(scannerCharArray[x] != ' ') {
					scannerCharArray[x] = evaluateLetter(scannerCharArray[x]);
				}
			}
			
			System.out.println(scannerCharArray);
		}
		scanner.close();
		System.exit(0);
	}
	
	public static char evaluateLetter(char charAtIndex) {
		char newLetter;
		
		switch (charAtIndex) {
        	case '1':
        		newLetter = '`';
        		break;
        	case '2':
        		newLetter = '1';
        		break;
        	case '3':
        		newLetter = '2';
        		break;
        	case '4':
        		newLetter = '3';
        		break;
        	case '5':
        		newLetter = '4';
        		break;
        	case '6':
        		newLetter = '5';
        		break;
        	case '7':
        		newLetter = '6';
        		break;
        	case '8':
        		newLetter = '7';
        		break;
        	case '9':
        		newLetter = '8';
        		break;
        	case '0':
        		newLetter = '9';
        		break;
        	case '-':
        		newLetter = '0';
        		break;
        	case '=':
        		newLetter = '-';
        		break;
        	case 'W':
        		newLetter = 'Q';
        		break;
        	case 'E':
        		newLetter = 'W';
        		break;
        	case 'R':
        		newLetter = 'E';
        		break;
        	case 'T':
        		newLetter = 'R';
        		break;
        	case 'Y':
        		newLetter = 'T';
        		break;
        	case 'U':
        		newLetter = 'Y';
        		break;
        	case 'I':
        		newLetter = 'U';
        		break;
        	case 'O':
        		newLetter = 'I';
        		break;
        	case 'P':
        		newLetter = 'O';
        		break;
        	case '[':
        		newLetter = 'P';
        		break;
        	case ']':
        		newLetter = '[';
        		break;
        	case '\\':
        		newLetter = ']';
        		break;
        	case 'S':
        		newLetter = 'A';
        		break;
        	case 'D':
        		newLetter = 'S';
        		break;
        	case 'F':
        		newLetter = 'D';
        		break;
        	case 'G':
        		newLetter = 'F';
        		break;
        	case 'H':
        		newLetter = 'G';
        		break;
        	case 'J':
        		newLetter = 'H';
        		break;
        	case 'K':
        		newLetter = 'J';
        		break;
        	case 'L':
        		newLetter = 'K';
        		break;
        	case ';':
        		newLetter = 'L';
        		break;
        	case '\'':
        		newLetter = ';';
        		break;
        	case 'X':
        		newLetter = 'Z';
        		break;
        	case 'C':
        		newLetter = 'X';
        		break;
        	case 'V':
        		newLetter = 'C';
        		break;
        	case 'B':
        		newLetter = 'V';
        		break;
        	case 'N':
        		newLetter = 'B';
        		break;
        	case 'M':
        		newLetter = 'N';
        		break;
        	case ',':
        		newLetter = 'M';
        		break;
        	case '.':
        		newLetter = ',';
        		break;
        	case '/':
        		newLetter = '.';
        		break;
        	default:
        		throw new IllegalArgumentException("Invalid character");
		}
		
		return newLetter;
	}

}
