public class Safety {
    public static void main(String[] args) {

        Worker w1 = new Worker();
        w1.setDaemon(true);
        w1.start();
        w1.isAlive();// Returns boolean
        Worker w2 = new Worker();
        w2.start();
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            w1.join();// main waits for w1 to finish
        } catch (Exception e) {
        }

        System.out.println(50000);
    }
}

// Thread using inheritance
class Worker extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("auis");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}