package oneToOne;

import hibernateUtil.CreateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* one- To- One : each student should have a unique address. 
 * One- To - Many :  a student can have any number of phone numbers. 
 */
public class Main {

	public static void main(String[] args) {
		Session session = CreateSessionFactory.getSessionFactory()
				.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address("OMR Road", "Chennai", "TN",
					"600097");
			Address address2 = new Address("Ring Road", "Banglore",
					"Karnataka", "560000");
			Student student1 = new Student("Eswar", address1);
			Student student2 = new Student("Joe", address2);
			session.save(student1);
			session.save(student2);
			transaction.commit();
			
			System.out.println(student1.getStudentAddress()+"\t"+student1.getStudentId()+"\t"+student1.getStudentName());

			//InsertPerson();
			//deletePerson();
			//updatePerson();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private static void updatePerson() {
		Session session = CreateSessionFactory.getSessionFactory()
				.openSession();
		Transaction transaction = null;
		try {
			/*Person p = (Person)session.load(Person.class,"1245");
			p.getPhone().setType("HOME"); */
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private static void deletePerson() {

		Session session = CreateSessionFactory.getSessionFactory()
				.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Student p = (Student) session.load(Student.class, "1");
			session.delete(p);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void InsertPerson() {
		Session session = CreateSessionFactory.getSessionFactory()
				.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address();
			Address address2 = new Address();
			Student student1 = new Student();
			Student student2 = new Student();

			address1.setAddressId(000000);
			address1.setCity("city");
			address1.setState("state");
			address1.setStreet("street");
			address1.setZipcode("zipcode");

			session.save(address1);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
