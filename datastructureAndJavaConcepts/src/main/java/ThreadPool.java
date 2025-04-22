import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
            // Create a thread pool with 4 threads
        ExecutorService execute = Executors.newFixedThreadPool(4);

            for(int i =0;i<10; i++){
                int taskId = i;
                //Simulate some work with sleep
                execute.submit(() -> {
                    System.out.println("Task "+taskId+" is running on thread: "
                                            +Thread.currentThread().getName());
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Task "+taskId+" completed");
                });
            }
            //shutdown executor
            execute.shutdown();
        }
}
