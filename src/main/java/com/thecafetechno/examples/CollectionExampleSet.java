package com.thecafetechno.examples;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thecafetechno.organisation.Employee;
import com.thecafetechno.util.HibernateUtil;

public class CollectionExampleSet {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setEmployeeName("Saurabh");
		Set<String> contactNumbers = new HashSet<String>();
		contactNumbers.add("123456");
		contactNumbers.add("231252");
		contactNumbers.add("863426");
		employee.setContactNumbers(contactNumbers);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Integer resultId = (Integer) session.save(employee);
		transaction.commit();

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Employee resultEmployee = (Employee) session.load(Employee.class,
				resultId);
		transaction.commit();

		Set<String> contactNumbersSet = resultEmployee.getContactNumbers();
		String employeeName = resultEmployee.getEmployeeName();

		for (String contactNumber : contactNumbersSet) {
			System.out.print(contactNumber + " ");
		}
		System.out.println();

	}
}
