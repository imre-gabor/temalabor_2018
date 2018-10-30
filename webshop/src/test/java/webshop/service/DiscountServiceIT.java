package webshop.service;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureTestDatabase
public class DiscountServiceIT {

	@Autowired
	DiscountService discountService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void testDiscountProductsInCategory() throws Exception {

		//ARRANGE
		
		Product product1 = new Product(1, "Product1", 100.0);
		Product product2 = new Product(2, "Product2", 200.0);
		product1 = productRepository.save(product1);
		product2 = productRepository.save(product2);
		
		Category category = new Category("ABC");
		category.addProduct(product1);
		category.addProduct(product2);
		categoryRepository.save(category);
				
		//ACT
		discountService.discountProductsInCategory("ABC", 10);
		
		//ASSERT
		product1 = productRepository.findByName("Product1").get(0);
		product2 = productRepository.findByName("Product2").get(0);
		
		double delta = 0.00001;
		assertThat(product1.getPrice(), closeTo(90.0, delta));
		assertThat(product2.getPrice(), closeTo(180.0, delta));
	}
	
}
