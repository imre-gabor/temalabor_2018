package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import webshop.model.Category;
import webshop.repository.CategoryRepository;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
	
	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//categoryRepository.save(new Category("test category"));
	}
	
	
}
