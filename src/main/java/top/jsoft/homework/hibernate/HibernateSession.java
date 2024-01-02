package top.jsoft.homework.hibernate;

import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import top.jsoft.homework.hibernate.entity.Student;

/**
 * @author psygrammator
 */
@NoArgsConstructor
public class HibernateSession implements AutoCloseable {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}