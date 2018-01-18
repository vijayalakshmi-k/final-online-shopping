package com.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class categoryclass implements Serializable 
{
	private static final long serialVersionUID = 1L;
@Id
private int cid;
private String cname;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
}
///@OneToMany(targetEntity=product.class, fetch=FetchType.EAGER mappedBy="category" )
/////private Set<product> product=new HashSet<product>(0);////


