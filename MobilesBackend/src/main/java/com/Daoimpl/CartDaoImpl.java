package com.Daoimpl;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CartDao;
import com.model.Cart;
import com.model.Product;

@Repository("cartDaoimpl")
public class CartDaoImpl implements CartDao {
	
	
	@Autowired 
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
this.sessionFactory=sessionFactory;
}
	
public void insertCart(Cart cart)
{

	Session session=sessionFactory.openSession();
    session.beginTransaction();
	 session.persist(cart);
	 session.getTransaction().commit();
}

public List<Cart> FindBycartId (String userid)
{
Session session=sessionFactory.openSession();
List<Cart> cr=null;
try
{
session.beginTransaction();
cr=(List<Cart>)session.createQuery("from Cart where usermailId=:email").setString("email and CartProductId=id", userid);
}
catch(HibernateException e)
{
	System.out.println(e.getMessage());
	session.getTransaction().rollback();
}
return cr;
}



	public Cart getCartById ( int cartId, String userid)
	{
	Session session=sessionFactory.openSession();
	Cart cr=null;
	try
	{
		
		session.beginTransaction();
		cr=(Cart)session.createQuery("from Cart where usermailId=:email and CartProductId=id");
	}
	catch(HibernateException e)
	{
		System.out.println(e.getMessage());
		session.getTransaction().rollback();
	}
	return cr;
	}


	public void deleteCart(Cart cart)
	{

		Session session=sessionFactory.openSession();
	    session.beginTransaction();
		 session.delete(cart);
		 session.getTransaction().commit();
	}
	
	
	public void updateCart(Cart cart)
	{

		Session session=sessionFactory.openSession();
	    session.beginTransaction();
		 session.update(cart);
		 session.getTransaction().commit();
	}

	public void inserCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}