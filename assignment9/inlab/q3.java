import java.util.*;

public class q3
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String inpt = sc.nextLine();
		
		String[] parts = inpt.split(",");
		
		String textInput = parts[0].trim();
		int num1 = Integer.parseInt(parts[1].trim());
		int num2 = Integer.parseInt(parts[2].trim());
		
// 		System.out.println(textInput.substring(num1,num2));
        for(int i = num1 ; i <= num2 ; i++ ){
            System.out.print(textInput.charAt(i));
        }
        
	}
}