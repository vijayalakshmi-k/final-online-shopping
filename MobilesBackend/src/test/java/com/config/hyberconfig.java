package com.config;
import java.util.Locale.Category;
import java.util.Properties;
import java.util.function.Supplier;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Daoimpl.CartDaoImpl;
import com.Daoimpl.CategoryDaoimpl;
import com.Daoimpl.OrdersDaoimpl;
import com.Daoimpl.ProductDaoimpl;
import com.Daoimpl.SupplierDaoimpl;
import com.Daoimpl.UserDaoimpl;
import com.model.Cart;
import com.model.Orders;
import com.model.Product;
import com.model.User;
@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hyberconfig
{
@SuppressWarnings("unchecked")
@Autowired
@Bean(name="datasource")
public  <Datasource>Datasource getH2Data()
{
	System.out.println("Hibernate is initiated");
	DriverManagerDataSource dsource=new DriverManagerDataSource();
	dsource.setDriverClassName("org.h2.Driver");
			dsource.setUrl("jdbc:h2:~/test");
			dsource.setUsername("sa");
			dsource.setPassword("");
			System.out.println("H2 connected");
			return  (Datasource) dsource;
			}
private Properties getHiber()
{
	Properties p=new Properties(); 
	p.put("hibernate.dialect","org.hibernate.dialect.H2dialect");
    p.put("hibernate.hbm2ddl.auto", "update");
	p.put("hibernate.show_sql", "true");

System.out.println("tables created");
return p;
} 
@Autowired
@Bean(name="sessionfactory")
public SessionFactory getSessionFactory(DataSource dataSource) 
{
 LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(dataSource);
    lsfb.addProperties(getHiber());
    lsfb.addAnnotatedClass(User.class);
    lsfb.addAnnotatedClass(Supplier.class);
    lsfb.addAnnotatedClass(Category.class);
    lsfb.addAnnotatedClass(Product.class);
    lsfb.addAnnotatedClass(Cart.class);
    lsfb.addAnnotatedClass(Orders.class);


   return lsfb.buildSessionFactory();
}

@Autowired
@Bean(name="UserDaoimpl")
public UserDaoimpl SaveUserData(SessionFactory sf)
{
	return new UserDaoimpl(sf);
}
@Autowired
@Bean(name="SupplierDaoimpl")
public SupplierDaoimpl SavesuppData(SessionFactory sf)
{
return new SupplierDaoimpl(sf);
}

@Autowired
@Bean(name="CategoryDaoimpl")
public CategoryDaoimpl SavecategoryData(SessionFactory sf)
{
return new CategoryDaoimpl(sf);
}

@Autowired
@Bean(name="CartDaoimpl")
public CartDaoImpl SaveCartData(SessionFactory sf)
{
return new CartDaoimpl(sf);
}


@Autowired
@Bean(name="OrdersDaoimpl")
public OrdersDaoimpl SaveOrdersData(SessionFactory sf)
{
return new OrdersDaoimpl(sf);
}
@Autowired
@Bean(name="ProductDaoimpl")
public ProductDaoimpl SaveproductData(SessionFactory sf)
{
return new ProductDaoimpl(sf);
}
@Autowired
@Bean(name="transaction manager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
{
  HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
  return transactionManager;
}


}
