
public class hw3 {
    public static void main(String[] args) {
        lock l1 = new lock();
        lock l2 = new lock();
        Cthread t1 = new Cthread(l1, l2);
        Cthread t2 = new Cthread(l2, l1);
        t1.start();
        t2.start();
    }
}

class Cthread extends Thread {
    public lock l;
    public lock l2;

    public Cthread(lock l, lock l2) {
        this.l = l;
        this.l2 = l2;
    }

    @Override
    public void run() {
        synchronized (l) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized (l2) {
                System.out.println("lock acquired");
            }
        }
    }
}

class lock {

    public lock() {
    }

}