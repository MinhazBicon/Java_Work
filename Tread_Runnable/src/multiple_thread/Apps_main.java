package multiple_thread;
/**
  @author minha
 */
public class Apps_main {

    //main method represend main thread
    public static void main(String[] args) {
        // whatever we write hrere it execiute by main thread
        // and thread execute job's in sequences
         //job1
        System.out.println("$$$$Application started$$");
         //job2
        for(int doc=1;doc<=2;doc++){
        System.out.println("^^^^Document printed...."+doc);
        }
        //job3
        Runnable r = new NewTask();
        Thread newtask= new Thread(r);
        newtask.start();
        //job4 is thread exucute parrallely
        MyThread mythread = new MyThread();//child thread//worker thread
        mythread.start();
       //jobb5
        System.out.println("####Application finish$$");   
    
    }    
}
