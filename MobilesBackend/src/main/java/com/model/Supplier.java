package com.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Supplier implements Serializable 
{

private static final long serialVersionUID = 1L;
@Id
private int sid;

@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER )
private Set<Product> product=new HashSet<Product>(0);


private String sname;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}


}