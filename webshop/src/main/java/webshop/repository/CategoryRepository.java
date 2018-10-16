package webshop.repository;

import java.util.List;

import webshop.model.Category;

public interface CategoryRepository {

	void save(Category category);
	
	List<Category> findByName(String name);
	
}
