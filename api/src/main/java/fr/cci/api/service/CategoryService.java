package fr.cci.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.cci.api.dtos.CategoryDTO;
import fr.cci.api.dtos.UserDTO;
import fr.cci.api.entities.ECategory;
import fr.cci.api.payload.responses.GetCategoryResponseDTO;
import fr.cci.api.repositories.ECategoryRepository;

@Service
public class CategoryService {
	
	private ECategoryRepository eCategoryRepository;
	
	public CategoryService(ECategoryRepository eCategoryRepository) {
		this.eCategoryRepository = eCategoryRepository;
	}
	
	public GetCategoryResponseDTO get() {
		
		List<ECategory> entitiesCategory = eCategoryRepository.findAll();
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		
		entitiesCategory.forEach((entity) -> {			
			CategoryDTO cDto = new CategoryDTO();
			cDto.setId(entity.getId());
			cDto.setName(entity.getName());
			
			List<UserDTO> users = new ArrayList<UserDTO>();
			entity.getUsers().forEach((user) ->  {
				UserDTO uDto = new UserDTO();
				uDto.setId(user.getId());
				uDto.setUsername(user.getUsername());
				users.add(uDto);
			});
			cDto.setUsers(users);
			dtos.add(cDto);
		});
		
		return new GetCategoryResponseDTO(dtos);		
	}	
}