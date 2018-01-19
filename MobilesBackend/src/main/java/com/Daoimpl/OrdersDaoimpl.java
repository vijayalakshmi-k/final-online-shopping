package com.Daoimpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Dao.OrderDao;
import com.model.Orders;
@Repository("OrderDaoimpl")
public class OrdersDaoimpl implements OrderDao
{
  @Autowired
    SessionFactory sessionFactory;
public OrdersDaoimpl (SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}

//@Transactional

public void insertorder(Orders order) {
	
	Session session=sessionFactory.openSession();
    session.beginTransaction();
	 session.persist(order);
	 session.getTransaction().commit();

	
}

public void insertorder(javax.persistence.criteria.Order order) {
	// TODO Auto-generated method stub
	
}

}