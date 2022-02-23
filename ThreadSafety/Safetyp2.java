/**
 * Safetyp2
 */
public class Safetyp2 {
    public static void main(String[] args) {

        shared s = new shared();
        test t = new test(s, " t1");
        test t2 = new test(s, " t2");
        t.start();
        t2.start();

    }
}

class test extends Thread {
    public shared t;
    public String s;

    public test(shared t, String s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            t.print("hello" + s);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

/**
 * InnerSafetyp2
 */
class shared {
    public void print(String s) {
        synchronized (this) {
            System.out.println(s);
        }
        System.out.println("S");
    }

}