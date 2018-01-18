package com.Daoimpl;
import java.util.List;
import java.util.Locale.Category;
import java.util.function.Supplier;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.Dao.supplierDao;

@Repository
@Service
public abstract class SupplierDaoimpl implements supplierDao

{
@Autowired
SessionFactory sessionFactory;
	

@Autowired
public SupplierDaoimpl (SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
public void insert(Supplier supplier)
{
	
		 Session session=sessionFactory.openSession();
	     session.beginTransaction();
		 session.saveOrUpdate(supplier);
		 session.getTransaction().commit();
	
}

public List<Supplier> retrieve()
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	List <Supplier>li=session.createQuery("from supplier").list();
	 session.getTransaction().commit();
	 return li;
}
public Supplier FindBySuppId (int sid)
{
Session session=sessionFactory.openSession();
Supplier s=null;
try
{
	
	session.beginTransaction();
	s=session.get(Supplier.class, sid);
	 session.getTransaction().commit();
}
catch(HibernateException e)
{
	System.out.println(e.getMessage());
	session.getTransaction().rollback();
}
return s;
}
}
























