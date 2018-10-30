package webshop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceTest {

	@InjectMocks
	DiscountService discountService;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public void testDiscountProductsInCategory() throws Exception {
		
		//ARRANGE
		Category category = new Category("ABC");
		Product product1 = new Product(1, "Product1", 100.0);
		Product product2 = new Product(2, "Product2", 200.0);
		category.addProduct(product1);
		category.addProduct(product2);
		
		when(categoryRepository.findByName("ABC")).thenReturn(Arrays.asList(category));
		
		//ACT
		discountService.discountProductsInCategory("ABC", 10);
		
		//ASSERT
		double delta = 0.00001;
		//rosszabbul olvasható
		//assertEquals(90.0, product1.getPrice(), delta);
		
		assertThat(product1.getPrice(), closeTo(90.0, delta));
		assertThat(product2.getPrice(), closeTo(180.0, delta));
	}
}
