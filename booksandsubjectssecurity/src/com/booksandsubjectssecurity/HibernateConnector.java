package com.booksandsubjectssecurity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class HibernateConnector 
{
	
	private static SessionFactory sessionFactory = buildSessionFactory();

private static SessionFactory buildSessionFactory()
{
	System.out.println("yeeeeeeeeeeeeee");
   try
   {
      if (sessionFactory == null)
      {    	  
    	  Configuration configuration = new Configuration().configure();
    	  StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
          registry.applySettings(configuration.getProperties());
          StandardServiceRegistry serviceRegistry = registry.build();
           
          sessionFactory = configuration.buildSessionFactory(serviceRegistry);   
    	
      }
      System.out.println("sessionfactory---->"+sessionFactory);
      return sessionFactory;
   } catch (Throwable ex)
   {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
   }
}

public static SessionFactory getSessionFactory()
{
	System.out.println("sessionFactory###"+sessionFactory);
   return sessionFactory;
}

public static void shutdown()
{
   getSessionFactory().close();
}
}