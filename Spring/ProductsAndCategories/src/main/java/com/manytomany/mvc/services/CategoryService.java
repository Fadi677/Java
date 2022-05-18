package com.manytomany.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.manytomany.mvc.models.Category;
import com.manytomany.mvc.models.Product;
import com.manytomany.mvc.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}


	public Category createNewCategory(Category newCategory) {
		return categoryRepository.save(newCategory);
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id) {
	     Optional<Category> optionalCategory = categoryRepository.findById(id);
	     if(optionalCategory.isPresent()) {
	         return optionalCategory.get();
	     } else {
	         return null;
	     }
	}
	
	public List<Category> findCategoriesForProduct(Product targetProduct){
		List<Category> categoriesForProduct= categoryRepository.findAllByProducts(targetProduct);
		return categoriesForProduct;
	}
	
	public List<Category> findCategoriesExc(Product thisProduct){
		List<Category> categoriesExc=categoryRepository.findByProductsNotContains(thisProduct);
		return categoriesExc;
	}
	
	public Category addCatToProduct(Category thisCategory, Product productToAdd) {
		thisCategory.getProducts().add(productToAdd);
		 Category updatedCategory=thisCategory;
		 return categoryRepository.save(updatedCategory);
		 
	 }
	
}
