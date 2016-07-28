
package org.formation.hibernate.client;

import org.formation.hibernate.entity.Professor;
import org.formation.hibernate.entity.Student;
import org.formation.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestClient {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();

			
			Professor p = new Professor("Physique", "Albert Einstein", 15000);
			Professor p1 = new Professor("Art", "Picasso", 14200);
			
			Student s = new Student("Premier", "Kirikou", p);
			Student s1 = new Student("Deuxieme", "Maltazard", p);
			
			p.getStudents().add(s);
			p.getStudents().add(s1);
			p1.getStudents().add(s);
			p1.getStudents().add(s1);
			
			session.persist(p);
			session.persist(p1);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		System.exit(0);

	}
}
