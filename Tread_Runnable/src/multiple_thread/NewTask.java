package multiple_thread ;
public class NewTask extends ApplyingRunnable implements Runnable {  
    @Override
    public void run() {
     for(int doc=1;doc<=3;doc++){
     System.out.println("!!!Printed Runnable_Document...."+doc);
    }
}
}
