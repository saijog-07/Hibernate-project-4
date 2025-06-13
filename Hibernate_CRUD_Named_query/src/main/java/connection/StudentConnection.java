package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.Student;

public class StudentConnection {

    private static SessionFactory sessionFactory;

    private StudentConnection() {
        // private constructor
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("hiber.config.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
