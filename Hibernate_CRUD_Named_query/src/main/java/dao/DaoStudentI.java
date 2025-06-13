package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import connection.StudentConnection;
import model.Student;

public class DaoStudentI implements StudentDao {

    private SessionFactory factory;

    public DaoStudentI() {
        factory = StudentConnection.getSessionFactory();
    }

    @Override
	public void serachHQLName(String name) {
	
		Session session=factory.openSession();
 
		
		
		Query <Student>Q=session.createQuery("from Student where name=:name",Student.class);
		Q.setParameter("name", name);
		 List<Student> usersList=  Q.list();
		
		 for(Student  u : usersList )
		 {
			 System.out.println(u.toString());
		 }
		
		
		
	}
    
    @Override
	public void serachHQLNamMarkse(String name,double marks) {
	
		Session session=factory.openSession();
 
		
		
		Query <Student>Q=session.createQuery("from Student where name=:name and marks=:marks",Student.class);
		Q.setParameter("name", name);
		Q.setParameter("marks", marks);
 
		 List<Student> usersList=  Q.list();
		
		 for(Student  u : usersList )
		 {
			 System.out.println(u.toString());
		 }
		
		
		
	}
    
    @Override
    public void searchUsingMarks(int marks) {
        Session session = factory.openSession();

        List<Student> student = session.createQuery("from Student", Student.class).list();

        student.stream()
        .filter(s -> s.getMarks() > marks)
        .forEach(s-> System.out.println(s.getName()));
    }
    
    
    
    
    
    public void removeByRollNo(int rollno) {
        Session session = factory.openSession();
        Transaction txTransaction = session.beginTransaction();

        //Query<Student> Q = session.createQuery("delete from Student where rollno = :rollno");
        Query <Student>Q=session.createNamedQuery("Student.removeRoll");
        Q.setParameter("rollno", rollno);

        int r = Q.executeUpdate();
        if (r > 0) {
            System.out.println("Removed");
        } else {
            System.out.println("Not Found");
        }

        txTransaction.commit();  
        session.close();         
    }
    
    @Override
    public void updateByRoll(int rollno, String newName) {
        Session session = factory.openSession();
        Transaction txTransaction = session.beginTransaction();

        Query<?> query = session.createQuery("update Student set name = :name where rollno = :rollno");
        query.setParameter("name", newName);
        query.setParameter("rollno", rollno);

        int result = query.executeUpdate();
        if (result > 0) {
            System.out.println("Updated");
        } else {
            System.out.println("Not Found");
        }

        txTransaction.commit();
        session.close();
    }

    
    @Override
    public void showData() {
    	
    	Session session = factory.openSession();
    	
    	//Query<Student> query = session.createQuery("from Student", Student.class);
    	Query <Student>query=session.createNamedQuery("Student.findAll");
    	query.setFirstResult(1);   // Skip first row
    	query.setMaxResults(20);   // Fetch next 20 rows

    	List<Student> students = query.list();
    	students.forEach(System.out::println);

    }
    
    @Override
    public void showData1(String name) {
    	
    	Session session = factory.openSession();
    	
    	//Query<Student> query = session.createQuery("from Student", Student.class);
    	Query <Student>query=session.createNamedQuery("Student.findStudent");
    	query.setParameter("name", name);
    	
    	

    	List<Student> students = query.list();
    	students.forEach(System.out::println);

    }

 


    
    

}
