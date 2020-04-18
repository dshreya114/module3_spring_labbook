package com.capg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capg.entities.Product;
import com.capg.exceptions.ProductNotFoundException;

@Repository
public class ProductDaoImpl implements IProductDao {

	private EntityManager  entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Product findById(int id) {
     Product product = entityManager.find(Product.class, id);
     if(product == null)
     {
    	throw new ProductNotFoundException("Product not found for this id : "+id); 
     }
		return product;
	}

	@Override
	public Product update(Product product) {
      product = getEntityManager().merge(product);
		return product;
	}

	@Override
	public List<Product> fetchAll() {
        String string = "from Product";
        TypedQuery<Product> query = entityManager.createQuery(string, Product.class);
        List<Product> product= query.getResultList();
		return product;
	}

	@Override
	public boolean remove(int id) {
     Product product = findById(id);
     getEntityManager().remove(product);
		return true;
	}

	
}
