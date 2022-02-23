public class VariableSafety {

    public static void main(String[] args) throws InterruptedException {
        ticket t = new ticket();
        System.out.println(t.next());
        System.out.println(t.next());
        VThread t1 = new VThread(t);
        VThread t2 = new VThread(t);
        t1.start();
        t2.start();
    }
}

class VThread extends Thread {
    private ticket t;

    public VThread(ticket t) {
        this.t = t;
    }

    public ticket getT() {
        return this.t;
    }

    public void setT(ticket t) {
        this.t = t;
    }

    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                System.out.println(t.next());
                sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}

class ticket {
    private int x;

    public synchronized int next() {
        x = x + 1;
        return x;
    }

}