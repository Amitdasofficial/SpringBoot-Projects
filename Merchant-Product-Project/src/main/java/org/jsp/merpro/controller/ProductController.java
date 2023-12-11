package org.jsp.merpro.controller;

import java.util.List;

import org.jsp.merpro.dto.Product;
import org.jsp.merpro.dto.ResponseStructure;
import org.jsp.merpro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	// save Product
	@PostMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,
			@PathVariable int merchant_id) {
		return productService.saveProduct(product, merchant_id);
	}

	// updateProduct
	@PutMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	// Find All Products
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		return productService.findAllProducts();
	}

	// find by brand name
	@GetMapping("/products/by-brand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable String brand) {
		return productService.findByBrandName(brand);
	}

	// find by Category
	@GetMapping("/products/by-category/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(@PathVariable String category) {
		return productService.findByCategory(category);
	}

	// findBy Merchantid
	@GetMapping("/products/by-merchant/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable int merchant_id) {
		return productService.findByMerchantId(merchant_id);
	}
}
