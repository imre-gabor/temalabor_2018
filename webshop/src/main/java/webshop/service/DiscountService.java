package webshop.service;

import java.util.List;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

public class DiscountService {

	ProductRepository productRepository;
	CategoryRepository categoryRepository;
	
	
	public void discountProductsInCategory(String categoryName, int percent) {
		
		List<Category> categories = categoryRepository.findByName(categoryName);
		
		for (Category category : categories) {
			for(Product product: category.getProducts()){
				product.setPrice(product.getPrice() * (1-percent/100.0));
				productRepository.save(product);
			}
		}
	}
	
}
