package fr.cci.api.payload.responses;

import java.util.ArrayList;
import java.util.List;

import fr.cci.api.dtos.CategoryDTO;

public class GetCategoryResponseDTO {

	private List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
	
	public GetCategoryResponseDTO() {}
	
	public GetCategoryResponseDTO(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}
