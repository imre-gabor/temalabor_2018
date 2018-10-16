package webshop.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

	private Integer id;
	private String name;
	
	private Set<Product> products;
}
