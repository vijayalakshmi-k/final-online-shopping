package com.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
@Component
@Entity
public class Supplier implements Serializable 
{

private static final long serialVersionUID = 1L;
@Id
private int sid;
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

///@OneToMany(targetEntity=product.class, fetch=FetchType.EAGER )
//private Set<product> product=new HashSet<product>(0);////


}