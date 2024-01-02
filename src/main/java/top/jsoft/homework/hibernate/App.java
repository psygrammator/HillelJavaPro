package top.jsoft.homework.hibernate;

import top.jsoft.homework.hibernate.dao.StudentDAO;
import top.jsoft.homework.hibernate.entity.Student;

/**
 * @author psygrammator
 */
public class App {
    public static void main(String[] args) {
        final StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student("Ira", "@gmail.com"));
        studentDAO.add(new Student("Natasha", "@gmail.com"));

        System.out.println(studentDAO.getAllStudents());

        Student student2 = studentDAO.getById(2);
        student2.setEmail("another email");
        studentDAO.save(student2);

        System.out.println(studentDAO.getAllStudents());

        Student student1 = studentDAO.getById(1);
        studentDAO.delete(student1);

        System.out.println(studentDAO.getAllStudents());

        studentDAO.getAllStudents().forEach(studentDAO::delete);
    }
}
