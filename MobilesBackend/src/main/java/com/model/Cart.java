package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Cart implements Serializable {
	
	@Id
	@GeneratedValue
	private int cartid;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getCartProductId() {
		return CartProductId;
	}
	public void setCartProductId(int cartProductId) {
		CartProductId = cartProductId;
	}
	public int getCartprice() {
		return cartprice;
	}
	public void setCartprice(int cartprice) {
		this.cartprice = cartprice;
	}
	public int getCartstock() {
		return cartstock;
	}
	public void setCartstock(int cartstock) {
		this.cartstock = cartstock;
	}
	public String getCartimage() {
		return cartimage;
	}
	public void setCartimage(String cartimage) {
		this.cartimage = cartimage;
	}
	public String getCartProductName() {
		return CartProductName;
	}
	public void setCartProductName(String cartProductName) {
		CartProductName = cartProductName;
	}
	private int CartProductId;
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="UserMailId")
private int cartprice;
private int cartstock;
private String cartimage;
private String CartProductName;

}
