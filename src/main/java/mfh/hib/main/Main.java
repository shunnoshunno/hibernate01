package mfh.hib.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mfh.hib.model.PersistentClass;

public class Main {

	final static Logger logger= Logger.getLogger(Main.class);
	
	
	public static void main(String[] args) {
	
		BasicConfigurator.configure();
		
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	          
	  PersistentClass ob=new PersistentClass();
	  
	  ob.setId(2);
	  ob.setName("FirstName");
	  ob.setAddress("Rajshahi");
	      
	    session.persist(ob);//persisting the object  
	      
	    t.commit();//transaction is commited  
	    session.close();  
	      
	    //System.out.println("successfully saved");  

	    logger.debug("Successfully Saved....");
	}

}
