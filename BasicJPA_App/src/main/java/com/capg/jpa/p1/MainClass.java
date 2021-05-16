package com.capg.jpa.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainClass {
	static Configuration cfg = new Configuration();
	static SessionFactory factory = cfg.configure().buildSessionFactory();
	static Session session = factory.openSession();// jdbc -> coonection object

	public static void main(String[] args) {
         MainClass m=new MainClass();
         m.Update_data();
	}

	public void Insert_data() {
		Transaction t = session.beginTransaction();

		// ---- write code for data base operation ----

		Account a = new Account();
		// a.setAccId(102);
		a.setAccountHolderName("Ramesh");
		a.setBalance(2000);

		session.save(a); // insert into Account .....

		System.out.println("  -->> Data Saved ..");
		t.commit();

		session.close();
		System.out.println("All Done");

	}

	public void Update_data() {
		Query query = session.createQuery("update Account set BALANCE=:b where ACCOUNTNUMBER=:id");

		query.setParameter("b", 45000);
		query.setParameter("id", 1);
		// Begin transaction
		Transaction t = session.beginTransaction();
		int result = query.executeUpdate();
		// Commit the transaction and close the session
		t.commit();
		System.out.println("No of rows updated: " + result);
	}
}