package top.jsoft.homework.hibernate.dao;

import org.hibernate.Session;
import top.jsoft.homework.hibernate.HibernateSession;
import top.jsoft.homework.hibernate.entity.Student;

import java.util.List;

/**
 * @author psygrammator
 */
public class StudentDAO {
    public void add(Student student) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    public void delete(Student student) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    public void save(Student student) {
        try(final Session session=HibernateSession
                .getSessionFactory()
                .openSession())
        {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
    }

    public Student getById(int id) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            return session.get(Student.class, id);
        }
    }

    public List<Student> getAllStudents() {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            return session.createQuery("From Student", Student.class)
                    .list();
        }
    }

}