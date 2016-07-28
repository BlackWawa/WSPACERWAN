
package org.formation.hibernate.client;

import org.formation.hibernate.entity.Professor;
import org.formation.hibernate.entity.Student;
import org.formation.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestClient2 {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();

			Professor pnew = (Professor) session.get(Professor.class, 1L);

			pnew.setName("PWEDIPIE");

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
