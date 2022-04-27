import java.util.concurrent.atomic.*;

/**
 * atom
 */
public class atom {
    public static void main(String[] args) {
        AtomicReference<Employee> ar = new AtomicReference<Employee>();

    }
}

class Employee {
    private String name;
    private AtomicInteger age;
    private Employee Manager;

    public Employee(String name, int age, Employee Manager) {
        this.name = name;
        this.age.set(age);
        this.Manager = Manager;
    }
}