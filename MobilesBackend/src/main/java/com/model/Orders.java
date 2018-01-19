package com.model;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class Orders  implements Serializable
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue

private String id;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getProductname() {
	return Productname;
}
public void setProductname(String productname) {
	Productname = productname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getProductCode() {
	return productCode;
}
public void setProductCode(String productCode) {
	this.productCode = productCode;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
private String Productname;
private int quantity;
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="usermailid")
private double amount;
private double price;
private String productCode;
	// TODO Auto-generated method stub
	
}



