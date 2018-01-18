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
private String Productname;
private int quantity;
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="usermailid")
private double amount;
private double price;
private String productCode;


}
