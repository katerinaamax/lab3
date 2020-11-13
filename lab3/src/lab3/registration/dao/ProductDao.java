package lab3.registration.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.exception.ConstraintViolationException;

import lab3.registration.model.Product;
import lab3.registration.util.HibernateUtil;	

public class ProductDao {
	
	public static int registerProduct(Product product) {
		Transaction transaction = null;
		Query query;
        int result = 1;

		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction= session.beginTransaction();
			
			try {
				session.save(product);
				result = 1;
			}
			catch (ConstraintViolationException e) {
				result = 0;
			}
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
        	result = 0;
		}
		return result;
	}
}
