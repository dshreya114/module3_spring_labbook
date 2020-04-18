package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.dao.IProductDao;
import com.capg.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	private IProductDao dao;
	
	public IProductDao getDao() {
		return dao;
	}
	
  @Autowired
	public void setDao(IProductDao dao) {
		this.dao = dao;
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id) ;
	}

	@Override
	public Product update(Product product) {
		return dao.update(product);
	}

	@Override
	public List<Product> fetchAll() {
      return dao.fetchAll();
	}

	@Override
	public boolean remove(int id) {
		return dao.remove(id);
	}

}
