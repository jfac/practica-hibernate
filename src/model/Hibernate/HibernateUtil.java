package model.Hibernate;

import org.hibernate.HibernateException; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static
	{
	    try 
	    { 
	        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    } catch (HibernateException he) 
	    { 
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
	        throw new ExceptionInInitializerError(he); 
	    } 
	}
	public static SessionFactory getSession(){
		return sessionFactory;
	}
}
