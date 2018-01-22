package com.Dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDAO
{
	public void insertSupplier(Supplier supplier);
	public  List<java.util.function.Supplier> retrieve();
	public java.util.function.Supplier findBySuppId(int sid) ;


}
