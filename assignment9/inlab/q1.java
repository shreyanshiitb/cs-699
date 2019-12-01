import java.util.*;
 
public class q1
{
    public static void main(String[ ] args)
    {
	int sum =0;
	int mul = 1;

      for(int i=0;i<args.length;i++)
	{	
		sum +=Integer.parseInt(args[i]);
		mul *=Integer.parseInt(args[i]);
	}

	System.out.println(args.length+", "+sum+", "+mul);
       
    }
}
