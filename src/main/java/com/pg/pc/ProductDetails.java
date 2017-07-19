package com.pg.pc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	protected String name;
	
	protected String category;

	public ProductDetails() {
		super();
	}

	public ProductDetails(Long id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDetails [productId=" + id + ", name=" + name + ", category=" + category + "]";
	}
}
