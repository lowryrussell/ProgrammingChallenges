import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
    public static void main(String[] args) {

    	Scanner scanner = new Scanner(System.in);
    	
    	int size = 0;
    	
        while (scanner.hasNext()) {
        	size = scanner.nextInt();
            int number = scanner.nextInt();

            if ((size == 0) && (number == 0)) {
                break;
            }

            System.out.printf("%s\n", getString(size, number));
        }
        
        scanner.close();
    }

    static String getString(int size, int number) {
    	
    	String stringNum = Integer.toString(number);
        final int totalChars = stringNum.length();
        String[][] buffer = new String[totalChars][];
        
        for (int x = 0; x < totalChars; x++) {
            buffer[x] = appendDigitCharsToRow(size, stringNum.charAt(x));
        }

        final int totalHeight = 2 * size + 3;
        StringBuilder builder = new StringBuilder();
        
        int row = 0;
        while (row < totalHeight) {
        	/* reset index after every row iteration */
        	int index = 0;
        	while (index < totalChars) {
        		builder.append(buffer[index][row]);
        		if (index < totalChars-1) {
        			builder.append(' ');
        		}
        		index++;
        	}
        	builder.append("\n");
        	row++;
        }

        return builder.toString();
    }

    static String[] appendDigitCharsToRow(int size, char Char) {
    							
        byte[] bitArray = {0077, 0024, 0155, 0165, 0126, 0163, 0173, 0025, 0177, 0167};

        int totalHeight = 2 * size + 3;
        String[] rows = new String[totalHeight];

        char[] charBuffer = new char[size];
        byte bitmap = bitArray[Char - '0'];
        
        StringBuilder builder = new StringBuilder();
        String appendedChars = "";

        if ((bitmap & 0001) > 0) {
        	Arrays.fill(charBuffer, '-');
        }
        else {
        	Arrays.fill(charBuffer,  ' ');
        }
        appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append(' ').toString();
        rows[0] = appendedChars;

        builder.setLength(0);
        if ((bitmap & 0100) > 0) {
        	Arrays.fill(charBuffer,  '-');
        }
        else {
        	Arrays.fill(charBuffer, ' ');
        }
        appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append(' ').toString();
        rows[size + 1] = appendedChars;

        builder.setLength(0);
        if ((bitmap & 0040) > 0) {
        	Arrays.fill(charBuffer,  '-');
        }
        else {
        	Arrays.fill(charBuffer, ' ');
        }
        appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append(' ').toString();
        rows[2 * size + 2] = appendedChars;

        builder.setLength(0);
        Arrays.fill(charBuffer, ' ');
        if ((bitmap & 0002) > 0) {
        	if ((bitmap & 0004) > 0) {
            	appendedChars = builder.append('|').append(String.valueOf(charBuffer)).append('|').toString();
        	}
        	else {
            	appendedChars = builder.append('|').append(String.valueOf(charBuffer)).append(' ').toString();
        	}
        }
        else {
        	if((bitmap & 0004) > 0) {
            	appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append('|').toString();
        	}
        	else {
            	appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append(' ').toString();
        	}
        }
        Arrays.fill(rows, 1, size + 1, appendedChars);

        builder.setLength(0);
        Arrays.fill(charBuffer, ' ');
        if ((bitmap & 0010) > 0) {
        	if ((bitmap & 0020) > 0) {
            	appendedChars = builder.append('|').append(String.valueOf(charBuffer)).append('|').toString();
        	}
        	else {
            	appendedChars = builder.append('|').append(String.valueOf(charBuffer)).append(' ').toString();
        	}
        }
        else {
        	if((bitmap & 0020) > 0) {
            	appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append('|').toString();
        	}
        	else {
            	appendedChars = builder.append(' ').append(String.valueOf(charBuffer)).append(' ').toString();
        	}
        }
        Arrays.fill(rows, size + 2, 2 * size + 2, appendedChars);
        
        return rows;
    }
}
