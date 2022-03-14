import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class pool {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hellooooo");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        for (int i = 0; i < 1000; i++) {
            pool.execute(r);
        }
    }
}
