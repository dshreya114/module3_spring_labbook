package com.capg.service;

import java.util.List;

import com.capg.entities.Product;

public interface IProductService {

	Product findById(int id);
	
    Product update(Product user);

	    List<Product> fetchAll();

	    boolean remove(int id);

}
