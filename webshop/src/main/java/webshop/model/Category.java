package webshop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private Set<Product> products;
	
	public Category() {
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void addProduct(Product product) {
		product.setCategory(this);
		if(this.products == null)
			this.products = new HashSet<>();
		this.products.add(product);
	}
	
}
