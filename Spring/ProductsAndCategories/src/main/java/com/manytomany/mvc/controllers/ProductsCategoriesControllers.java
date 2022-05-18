package com.manytomany.mvc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manytomany.mvc.models.Category;
import com.manytomany.mvc.models.Product;
import com.manytomany.mvc.services.CategoryService;
import com.manytomany.mvc.services.ProductService;


@Controller
public class ProductsCategoriesControllers {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductsCategoriesControllers(ProductService productService, CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
	}
	
	@GetMapping("/")
	public String homePage(Model model) {
		List<Product> allProducts=productService.allProducts();
		List<Category> allCategories=categoryService.allCategories();
		model.addAttribute("allTheProducts", allProducts);
		model.addAttribute("allTheCategories", allCategories);
		return "home.jsp";
	}
	
	@GetMapping("products/new")
	public String newProductPage(@ModelAttribute("createNewProduct") Product newProduct) {
		return "newproduct.jsp";
	}
	
	@PostMapping("products/new")
	public String createProduct(@Valid @ModelAttribute("createNewProduct") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		}
		else {
			Product latestProduct=productService.createNewProduct(newProduct);
			Long latestProductId=latestProduct.getId();
			return "redirect:products/"+latestProductId;
		}
		
	}
	
	@GetMapping("products/{id}")
	public String showProduct(@ModelAttribute("productsModel") Product product,@PathVariable("id") Long id, Model model) {
		Product thisProduct = productService.findProductById(id);
		model.addAttribute("theProduct", thisProduct);
		List<Category> categoriesFor=categoryService.findCategoriesForProduct(thisProduct);
		model.addAttribute("categoriesForTheProduct", categoriesFor);
		List<Category> categoriesExcProduct=categoryService.findCategoriesExc(thisProduct);
		model.addAttribute("categoriesExceptTheProduct",categoriesExcProduct);
		return "showproduct.jsp";
	}
	
	@PostMapping("products/{id}/addCategory")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("categories") Long catId,Model model) {
		Product thisProduct = productService.findProductById(id);
		Category catToAdd=categoryService.findCategoryById(catId);
		productService.addCatToProduct(thisProduct, catToAdd);
		return "redirect:/products/{id}";
	}
	
	
	
	@GetMapping("categories/new")
	public String newCategoryPage(@ModelAttribute("createNewCategory") Category newCategory) {
		return "newcategory.jsp";
	}
	
	@PostMapping("categories/new")
	public String createCategory(@Valid @ModelAttribute("createNewCategory") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		}
		else {
			categoryService.createNewCategory(newCategory);
		}
		return "redirect:/";
	}
	
	@GetMapping("categories/{id}")
	public String showCategory(@ModelAttribute("CategoriesModel") Category category, @PathVariable("id") Long id, Model model) {
		Category thisCategory=categoryService.findCategoryById(id);
		model.addAttribute("theCategory", thisCategory);
		List<Product> productsFor=productService.findProductsForCategory(thisCategory);
		model.addAttribute("productsForTheCategory", productsFor);
		List<Product> productsExcCategory=productService.findProductsExc(thisCategory);
		model.addAttribute("productsExcCategory", productsExcCategory);
		return "showcategory.jsp";
	}

	
	@PostMapping("categories/{id}/addProduct")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("products") Long productId,Model model) {
		Product thisProduct = productService.findProductById(productId);
		Category catToAdd=categoryService.findCategoryById(id);
		categoryService.addCatToProduct(catToAdd, thisProduct);
		return "redirect:/categories/{id}";
	}
	
}
