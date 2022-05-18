package com.manytomany.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manytomany.mvc.models.Category;
import com.manytomany.mvc.models.Product;
import com.manytomany.mvc.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	private CategoryService categoryService;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	public Product createNewProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	 public Product findProductById(Long id) {
	     Optional<Product> optionalProduct = productRepository.findById(id);
	     if(optionalProduct.isPresent()) {
	         return optionalProduct.get();
	     } else {
	         return null;
	     }
	}
	 
	 public List<Product> allProducts() {
		 return productRepository.findAll();
	 }
	 
	 public Product addCatToProduct(Product thisProduct, Category categoryToAdd) {
		 thisProduct.getCategories().add(categoryToAdd);
		 Product updatedProduct=thisProduct;
		 return productRepository.save(updatedProduct);
		 
	 }
	 
	 public List<Product> findProductsForCategory(Category targetCategory){
			List<Product> productsForCategory= productRepository.findAllByCategories(targetCategory);
			return productsForCategory;
		}

	public List<Product> findProductsExc(Category thisCategory){
		List<Product> productsExc=productRepository.findByCategoriesNotContains(thisCategory);
		return productsExc;
	}
	
}
