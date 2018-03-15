import java.util.Scanner;
 
class Main {
	
    private final static int MAX_INTEGER = 1000000;
    
    public static void main(String args[]) {

    	Scanner scanner = new Scanner(System.in);
    	boolean nextVal = true;
        
        while (nextVal){
        	
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            
            int minValue = Math.min(i, j);
            int maxValue = Math.max(i, j);
 
            if (minValue > 0 && maxValue > 0 && minValue < MAX_INTEGER && maxValue < MAX_INTEGER) {
            	
                int max = 0;
 
                for (int valInCycle = minValue; valInCycle <= maxValue; valInCycle++) {
                    max = Math.max(max, countCycleTotal(valInCycle, 1));
                }
                
                System.out.println(i + " " + j + " " + max);
            }
            
            if (!scanner.hasNext()) {
            	nextVal = false;
            }
        }
        scanner.close();
    }

    static int countCycleTotal(int n, int length) {
    	
        if (n > 1) {
        	
            if (n % 2 == 0) {
                n = n / 2;
            }
            else {
                n = (3 * n) + 1;
            }
            
            length += 1;
            
            return countCycleTotal(n, length);
        }
        else {
            return length;
        }
    }
}