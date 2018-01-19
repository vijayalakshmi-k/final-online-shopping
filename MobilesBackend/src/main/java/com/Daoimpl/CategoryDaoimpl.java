package com.Daoimpl;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.model.Product;
	@Repository
	@Service
	public class CategoryDaoimpl implements CategoryDao
	{
@Autowired
SessionFactory sessionFactory;
@Autowired
public CategoryDaoimpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
public void insertCategory(Category category)
{
	 Session session=sessionFactory.openSession();
     session.beginTransaction();
	 session.saveOrUpdate(category);
	 session.getTransaction().commit();

}


public  List<Category> retrieve()
{
	
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	List <Category>li=session.createQuery("from Category").list();
session.getTransaction().commit();
return li;

	
	
	
}

	public Category FindBycategoryId (int cid)
	{
	Session session=sessionFactory.openSession();
	Category c=null;
	try
	{
		
		session.beginTransaction();
		c=session.get(Category.class, cid);
		@SuppressWarnings("unchecked")
		List <Product>li=session.createQuery("from Category").list();
       session.getTransaction().commit();
       return c;
	}
	catch(HibernateException e)
	{
		System.out.println(e.getMessage());
		session.getTransaction().rollback();
	}
	return c;
			
	}
	public void insertCategory(com.model.Category category) {
		// TODO Auto-generated method stub
		
	}
		
	}
