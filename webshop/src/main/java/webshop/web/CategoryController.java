package webshop.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webshop.model.Category;
import webshop.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping
	public String getAllCategories(Map<String, Object> model) {
		
		List<Category> allCategories = categoryRepository.findAll();
		model.put("categories", allCategories);	
		model.put("category", new Category());
		return "index";
	}
	
	@PostMapping
	public String createCategory(Map<String, Object> model, Category category) {
		categoryRepository.save(category);
		return "redirect:/category";
	}
	
}
