package org.jsp.merpro.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merpro.dto.Product;
import org.jsp.merpro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;

	// save Product
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Update Product
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	//Find all Products
	public List<Product> findAllProducts()
	{
		return productRepository.findAll();
	}
          //find by id
	public Optional<Product> findById(int id) {
		
		return productRepository.findById(id);
	}
	
	//find by brandname
	public List<Product> findByBrand(String brand)
	{
		return productRepository.findByBrand(brand);
	}
	
	//find by category
	public List<Product> findByCategory(String category)
	{
		return productRepository.findByCategory(category);
	}
	      //find by merchant Id
	public List<Product> findByMerchantId(int id)
	{
		return productRepository.findByMerchantId(id);
	}
}
