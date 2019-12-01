import java.util.*;


   public class q2 {

    public static void main(String[] args) {
    
       // Scanner s = new Scanner(System.in);
        Random r = new Random();

        int i,n=1000000;
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        int d[] = new int[n];
        long endTime,totalTime,startTime;
        
        for(i=0;i<n;i++)
        {
            a[i] = r.nextInt(10000);//to prevent overflow
            b[i] = r.nextInt(10000);
        }
      
        Runnable add = new Add(a, b, n);
        Runnable mul = new Multiply(a, b, n);
        Thread t1 = new Thread(add); 
        Thread t2 = new Thread(mul); 
        
        
        startTime = System.nanoTime();
        t1.start(); 
        t2.start(); 

        try {
            t1.join();
            t2.join();

        }
        catch (Exception e) {
        
            e.printStackTrace();
        }

        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println(totalTime);//time in nano seconds
        
        
        startTime = System.nanoTime();
        for(i=0;i<n;i++)
            c[i]=a[i]+b[i];
        
        for(i=0;i<n;i++)
            d[i]=a[i]*b[i];
        
        
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println(totalTime);
   }

    private static class Add implements Runnable { 
    private int a[],b[],c[],n;
        public Add(int a[], int b[], int n) {
            this.a=a;
            this.b=b;
            this.n = n;
            c = new int[n];

        }

		public void run() 
		{ 
            int i=0;
			try {
                for(i=0;i<n;i++){
                    c[i]=a[i]+b[i];
                    
                   // Thread.sleep(1000);
                }
            } catch (Exception e) {
                
                e.printStackTrace();
            }
            // System.out.println(c[0]);
            // System.out.println(c[1]);
		} 
	} 

    private static class Multiply implements Runnable { 
        private int a[],b[],d[],n;
        public Multiply(int a[], int b[], int n) {
                this.a=a;
                this.b=b;
                this.n = n;
                d = new int[n];
            }
    
            public void run() 
            { 
                int i=0;
                try {
                    for(i=0;i<n;i++){
                        d[i]=a[i]*b[i];
                        
                        //Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
                // System.out.println(d[0]);
                // System.out.println(d[1]);

            } 
        } 
}

/*
Conclusion:

1- Have written and tested a sequential program sepearately and compared the execution time of both:
multi-threaded as well as the sequential program (in nanoseconds)
2- Multi-threaded program took LESS execution time as compared to the sequential (non-threaded) program 
3-checked for N>1000. We took N=100000 and the execution time difference was significant

*/
