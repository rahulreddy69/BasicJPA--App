package com.capg.jpa.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class Update_Data {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		Session session = factory.openSession();// jdbc -> coonection object

		
		Query query = session.createQuery("update Account set BALANCE=:b where ACCOUNTNUMBER=:id");
		
		query.setParameter("b", 45000);
        query.setParameter("id", 1);
        // Begin transaction
        Transaction t = session.beginTransaction();
        int result = query.executeUpdate();
        // Commit the transaction and close the session
        t.commit();
        System.out.println("No of rows updated: "+result);
		
		
	}
}