package webshop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.model.Product;
import webshop.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
