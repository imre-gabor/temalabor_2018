package webshop.repository;

import java.util.List;

import webshop.model.Product;

public interface ProductRepository {

	void save(Product p);
	
	List<Product> findByName(String name);
	
}
