package com.Daoimpl;
import java.util.List;
import java.util.Locale.Category;
import java.util.function.Supplier;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.Dao.ProductDao;
import com.model.Product;
public class ProductDaoimpl implements ProductDao 
{
@Autowired
SessionFactory sessionFactory;
	@Autowired
public ProductDaoimpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
public void insertproduct(Product product)
{
	 Session session=sessionFactory.openSession();
     session.beginTransaction();
	 session.saveOrUpdate(product);
	 session.getTransaction().commit();
	 }
public List<Product> retrieve()
{
	
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	List <Product>li=session.createQuery("from product").list();
	 session.getTransaction().commit();
	 return li;
}
public Product FindByProductId (int pid)
{
Session session=sessionFactory.openSession();
Product p=null;
try
{
	
	session.beginTransaction();
	p=session.get(Product.class, pid);
	 session.getTransaction().commit();
}
catch(HibernateException e)
{
	System.out.println(e.getMessage());
	session.getTransaction().rollback();
}
return p;
}

	public List<Product>getProdByCatId(int cid)
	{
		Session session=sessionFactory.openSession();
		List<Product> Prod=null;
		try {
			session.beginTransaction();
			Prod=session.createQuery("from product where  cid" +cid).list();
			session.getTransaction().commit();

		}
			
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return Prod;

	}

	private void commit() {
		// TODO Auto-generated method stub
		
	}
	public void update(Product p)
	{
		Session session=sessionFactory.openSession();
		session.update(p);
		session.getTransaction().commit();
	}
	
	
	public void deleteProduct(int pid)
	{
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		Product p=(Product)session.get(Product.class,pid);
		session.delete(p);
		session.getTransaction().commit();
	}
			
	
	public Product FndByPId ()
	{
		Session session=sessionFactory.openSession();
		Product p=null;
		try
		{
			
					session.beginTransaction();
			p=(Product)session.get(Product.class,p);
			session.getTransaction().commit();

		}
			
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return p;

	}

	
	
	
	
	}
	
	
	
	
}





	
	


