package webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@Service
public class DiscountService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	public void discountProductsInCategory(String categoryName, int percent) {
		
		List<Category> categories = categoryRepository.findByName(categoryName);
		
		for (Category category : categories) {
			for(Product product: category.getProducts()){
				product.setPrice(product.getPrice() * (1-percent/100.0));
				//fölösleges a save, mert a product menedzselt állapotú a tranzakcióban
				//productRepository.save(product);
			}
		}
	}
	
}
