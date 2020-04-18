package com.capg.dao;

import java.util.List;
import com.capg.entities.Product;

public interface IProductDao {

     Product findById(int id);
	
    Product update(Product user);

	  List<Product> fetchAll();

	    boolean remove(int id);
}
