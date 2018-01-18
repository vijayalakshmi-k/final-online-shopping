package com.Daoimpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.Dao.UserDao;
import com.model.User;
public class UserDaoimpl implements UserDao
{
@Autowired
SessionFactory sessionFactory;
public UserDaoimpl(SessionFactory sessionfactory)
	{
	super();
	this.sessionFactory = sessionFactory;

}

   // @Transactional// 
	public void insertUser(User user) 
	{
		 Session session=sessionFactory.openSession();
	     session.beginTransaction();
		 session.saveOrUpdate(user);
		 session.getTransaction().commit();
	}
	

public User FindByEmail(String emails)
{
	Session session=sessionFactory.openSession();
	User u=null;

try
{
	session.beginTransaction();
	u=session.get(User.class, "email");
}
catch(HibernateException e)
{
	  System.out.println(e.getMessage());
	session.getTransaction().rollback();

}
return u;
}











}
