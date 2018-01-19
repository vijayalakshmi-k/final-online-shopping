package com.Daoimpl;
import java.util.List;
import java.util.function.Supplier;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.SupplierDAO;

@Repository(value="supplierDAO")
@Service
public  class SupplierDaoimpl implements SupplierDAO

{
@Autowired
private SessionFactory sessionFactory;
	

public SupplierDaoimpl(SessionFactory sf) {
	this.sessionFactory=sessionFactory;
}
public SessionFactory getSessionFactory() {
	return sessionFactory;
}
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

public void insertSupplier(com.model.Supplier supplier) {


	
	 Session session=sessionFactory.openSession();
    session.beginTransaction();
	 session.saveOrUpdate(supplier);
	 session.getTransaction().commit();
}
public static Object retrieve() {
	// TODO Auto-generated method stub
	return null;
}
public Supplier findBySuppId(int sid) 
{
	Session session=sessionFactory.openSession();
	Supplier s=null;
	try
	{
		session.beginTransaction();
		s=session.get(Supplier.class, sid);
		session.getTransaction();
	}
	catch(HibernateException e)
	{
		System.out.println(e.getMessage());
		session.getTransaction().rollback();
	}
	return s;
	
}









}
























