package com.model;

import java.io.Serializable;
import java.util.Locale.Category;
import java.util.function.Supplier;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Entity
public class Product implements Serializable 
{

	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
private int pid;
private String pname;
private String pdescription;
private double price;
private int stock;

@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="cid")
private Category category;

	

@SuppressWarnings("rawtypes")
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="sid")
private Supplier supplier;


MultipartFile pimage;
private String imgname;



public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPdescription() {
	return pdescription;
}
public void setPdescription(String pdescription) {
	this.pdescription = pdescription;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
@SuppressWarnings("rawtypes")
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
public String getImgname() {
	return imgname;
}
public void setImgname(String imgname) {
	this.imgname = imgname;
}
}





























