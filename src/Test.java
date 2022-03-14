public class Test {
    public static void main(String[] args) throws InterruptedException {
        lock l1 = new lock();
        Cthread t1 = new Cthread(l1);
        Cthread t2 = new Cthread(l1);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        synchronized (l1) {
            l1.notifyAll();
        }
    }
}

class Cthread extends Thread {
    public lock l;

    public Cthread(lock l) {
        this.l = l;
    }

    @Override
    public void run() {
        try {
            synchronized (l) {
                l.wait();

            }

            System.out.println("process complete");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class lock {

    public lock() {
    }

}