import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class q4 { 
    
    public static void main(String[] args) 
	{ 
		Thread t1 = new Thread(new q4().new TimeThread()); 
		t1.start(); 
	} 

	private class TimeThread implements Runnable { 

		public void run() 
		{ 
			try {
                while(true) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    System.out.print(dtf.format(now)+"\r");  

                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		} 
	} 
} 
