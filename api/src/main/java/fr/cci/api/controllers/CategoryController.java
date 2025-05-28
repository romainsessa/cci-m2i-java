package fr.cci.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.api.payload.responses.GetCategoryResponseDTO;
import fr.cci.api.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
		
	@GetMapping
	public GetCategoryResponseDTO get() {
		return this.categoryService.get();
	}
	
}
