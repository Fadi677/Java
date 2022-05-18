package com.manytomany.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manytomany.mvc.models.Category;
import com.manytomany.mvc.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	//get all products
	List<Product> findAll();
	
	// Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any products a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);

}
