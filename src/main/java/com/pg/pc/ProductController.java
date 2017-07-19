package com.pg.pc;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	protected Logger logger = Logger
			.getLogger(ProductController.class.getName());

	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/products")
	public ProductDetails[] all() {
		logger.info("product-details-micros --> all() invoked");
		List<ProductDetails> allProducts = (List<ProductDetails>) productRepository.findAll();
		logger.info("product-details-micros --> all() retrieved : " + allProducts.size());
		return allProducts.toArray(new ProductDetails[allProducts.size()]);
	}
	
	@GetMapping(path="/addproduct")
	public @ResponseBody String addNewProduct(@RequestParam String name
			, @RequestParam String category) {
		
		logger.info("product-details-micros --> addNewProduct() invoked");
		
		ProductDetails productDetails = new ProductDetails();
		productDetails.setName(name);
		productDetails.setCategory(category);
		productRepository.save(productDetails);
		return "added";
	}

	@RequestMapping("/products/{id}")
	public ProductDetails byId(@PathVariable("id") Long id) {
		logger.info("product-details-micros --> byId() invoked");
		ProductDetails productDetails = productRepository.findOne(id);
		logger.info("product-details-micros --> byId() retrieved : " + productDetails);
		return productDetails;
	}
}