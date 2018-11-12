package webshop.web;

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
	public String home(Map<String, Object> model) {
		model.put("categoryCount", categoryRepository.count());
		model.put("category", new Category());
		return "index";
	}
	
	
	@PostMapping
	public String addCategory(Category category, Map<String, Object> model) {
		categoryRepository.save(category);
		return "redirect:/category";
	}
}
