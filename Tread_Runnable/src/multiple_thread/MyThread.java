package multiple_thread;
//MyThread is a now thread
public class MyThread extends Thread {
   @Override 
   public void run(){
    
     for(int doc=1;doc<4;doc++){
     System.out.println("***Thread Document....."+doc);
     
     }     
}
}
