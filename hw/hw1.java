public class hw1 {
    public static void main(String[] args) {
        lock l1 = new lock("lock 1");
        lock l2 = new lock("lock 2");
        Cthread c1 = new Cthread(l1, l2);
        Cthread c2 = new Cthread(l2, l1);
        c2.start();
        c1.start();
    }
}

class Cthread extends Thread {
    private lock l;
    private lock l2;

    public Cthread(lock l, lock l2) {
        this.l = l;
        this.l2 = l2;
    }

    @Override
    public void run() {
        synchronized (l) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized (l2) {
                System.out.println("hello");
            }
        }
    }
}

class lock {
    private String name;

    public lock(String name) {
        this.name = name;
    }
}