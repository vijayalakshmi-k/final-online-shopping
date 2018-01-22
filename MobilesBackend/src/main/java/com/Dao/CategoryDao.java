package com.Dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao
{
public void insertCategory(Category category);

public  List<java.util.Locale.Category> retrieve();
public java.util.Locale.Category FindBycategoryId (int cid);


}
