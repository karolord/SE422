import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class app {
    public static void main(String[] args) throws InterruptedException {
        Student s1 = new Student();
        Student s2 = new Student();
        test(s1);
        s1.lock.lock();
        s1.lock.lock();
        s1.lock.lock();
        s1.lock.lock();
        s1.lock.lock();
        System.out.println(((ReentrantLock) s1.lock).getHoldCount());
        s1.lock.unlock();
        s1.lock.lockInterruptibly();
        System.out.println(s1.toString());
    }

    public static void test(Student s) {
        s.lock.lock();
        s.setGpa(5);
        s.lock.unlock();

    }
}

class Student {
    private String name;
    private int gpa;
    public Lock lock;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return this.gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public Lock getLock() {
        return this.lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Student() {

        this.lock = new ReentrantLock();
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", gpa='" + getGpa() + "'" +
                ", lock='" + getLock() + "'" +
                "}";
    }

}