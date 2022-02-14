public class Threads {
    public static void main(String[] args) {
        computation1 c1 = new computation1();
        computation2 c2 = new computation2();
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
        // c1.run()
        // c2.run()
    }
}

class computation1 implements Runnable {
    public void run() {
        while (true) {
            System.out.println("1");
        }

    }
}

class computation2 implements Runnable {
    public void run() {
        while (true) {
            System.out.println("1");
        }

    }
}