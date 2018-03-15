import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	static String a, b;

	public static void main(String[] args) throws IOException {
		
		//RUNTIME ERROR WITH SCANNER. WHY?
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scanner = new Scanner(System.in);
        
		while((a = scanner.readLine()) != null) {
			
			int charArr1[] = new int[26];
			int charArr2[] = new int[26];
			
			b = scanner.readLine();

			for(int x = 0; x < a.length(); x++) {
				
                if(a.charAt(x)>='a' && a.charAt(x)<='z'){
                	
    				charArr1[a.charAt(x) - 97]++;
                }
            }
			
			for(int x = 0; x < b.length(); x++) {
				
                if(b.charAt(x)>='a' && b.charAt(x)<='z'){
                	
    				charArr2[b.charAt(x) - 97]++;
                }
            }
			
			String val = "";
			for(int x = 0; x < 26; x++) {
				
				int min = (char)Math.min(charArr2[x], charArr1[x]);
				while(min-- > 0) {
					
					val += (char)(x+97);
				}
			}
			
			System.out.println(val);
		}
		
		
	}

}
