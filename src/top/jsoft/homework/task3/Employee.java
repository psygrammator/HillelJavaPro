package top.jsoft.homework.task3;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Employee {
    private final String fullName;
    private final int position;
    private final String email;
    private final String phone;
    private final int age;

    public Employee(String fullName, int position, String email, String phone, int age)
    {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }


    public String get_fullName() {
        return fullName;
    }

    public int get_position() {
        return position;
    }

    public String get_email() {
        return email;
    }

    public String get_phone() {
        return phone;
    }

    public int get_age() {
        return age;
    }
}
