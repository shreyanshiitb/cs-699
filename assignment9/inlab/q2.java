import java.util.*;
import java.util.Random; 

public class q2
	{
		public static void main(String[] args)
		{	
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			Random r = new Random();
			
			int a[] = new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]= r.nextInt();
				
			}
		
			//[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			System.out.println(mean(a));
			System.out.println(sd(a));
		}


		public static double sd(int a[])
    	{
        double standardDeviation = 0.0;
        int length = a.length;
    
        double mean = mean(a);
        for(double num: a) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/length);
    }


    public static double mean(int a[])
    {
        double sum = 0.0;
        int length = a.length;
        for(double num : a) {
            sum += num;
        }
        double mean = sum/length;
       
        return mean;
    }

	}
