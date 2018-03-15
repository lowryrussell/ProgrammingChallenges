import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int y;
	static int array1[] = new int[3100];
	static int array2[] = new int[3100];
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			y = scanner.nextInt();
			for (int x = 0; x < y; x++) {
				array1[x] = scanner.nextInt();
			}
			isJolly();
		}
	}
	
	static boolean isJolly() {
		
		for (int x = 0; x < y - 1; x++) {
			array2[x] = Math.abs(array1[x + 1] - array1[x]);
		}
		Arrays.sort(array2);
		//place 0's at end of array
		moveAllZerosToEnd(array2);
		
		for (int x = 0; x < y - 1; x++) {
			if (array2[x] != x + 1) {
				System.out.print("Not jolly\n");
				return false;
			}
		}
		System.out.print("Jolly\n");
		return true;
	}
	
	static void moveAllZerosToEnd(int[] array) {
		int size = array2.length;
        int count = 0;
  
        for (int i = 0; i < size; i++) {
        	
            if (array2[i] != 0) {
                array2[count++] = array2[i];
            }
        }
  
        while (count < size) {
            array2[count++] = 0;
        }
    }  

}
