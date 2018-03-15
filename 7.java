import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		//int stackOfFlapjacks[] = new int[30];
		Scanner scanner = new Scanner(System.in);
				
		String next;
		
		while(scanner.hasNextInt()) {
			
			next = scanner.nextLine();
			System.out.println(next);
			ArrayList<Integer> stackOfFlapjacks = new ArrayList<>();
			StringTokenizer st=new StringTokenizer(next);
			
			while(st.hasMoreTokens()) {
				//System.out.println(seq.charAt(x));
				stackOfFlapjacks.add(Integer.parseInt(st.nextToken()));
			}
			
			int unsortedArr[] = new int[stackOfFlapjacks.size()];
			for(int z = 0; z < stackOfFlapjacks.size(); z++) {
				unsortedArr[z] = stackOfFlapjacks.get(z);
			}
			
			int sortedArr[] = Arrays.copyOf(unsortedArr, unsortedArr.length);
			Arrays.sort(sortedArr);
			
			StringBuilder sb = new StringBuilder();
			
			for(int z = unsortedArr.length - 1; z >= 0; z--) {
				
				if(unsortedArr[z] != sortedArr[z]) {
					if(unsortedArr[0] != sortedArr[z]) {
						int pointer;
						for(pointer = z - 1; pointer >= 0; pointer--) {
							if(unsortedArr[pointer] == sortedArr[z]) {
								break;
							}
						}
						
						int tempUnsorted[] = Arrays.copyOf(unsortedArr, unsortedArr.length);
						
						int end = unsortedArr.length - (unsortedArr.length - pointer);
						for(int p = 0; p <= end; p++) {
							unsortedArr[p] = tempUnsorted[end - p];
						}
						
						sb.append((unsortedArr.length - pointer) + " ");
					}
					int tempUnsorted[] = Arrays.copyOf(unsortedArr, unsortedArr.length);
					
					int end = unsortedArr.length - (unsortedArr.length - z);
					for(int p = 0; p <= end; p++) {
						unsortedArr[p] = tempUnsorted[end - p];
					}
					sb.append((unsortedArr.length - z) + " ");
				}
				
			}
			sb.append("0");
			System.out.println(sb.toString());
		}
		
		// TODO Auto-generated method stub

	}

}
