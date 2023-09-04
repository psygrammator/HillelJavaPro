package top.jsoft.homework.task3;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Run {
    public static void main(String[] args) {
        final Employee employee = new Employee("HNIEDASH VLADISLAV", 1, "********@gmail.com", "+38093*******", 27);
        System.out.println("Employer data.");
        System.out.println("FullName: " + employee.get_fullName());
        System.out.println("Position: " + employee.get_position());
        System.out.println("Email: " + employee.get_email());
        System.out.println("Phone: " + employee.get_phone());
        System.out.println("Age: " + employee.get_age());
        System.out.println(System.lineSeparator());
        Car.start();
    }
}
