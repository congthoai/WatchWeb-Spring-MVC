package com.watch.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.watch.dto.TypeDTO;
import com.watch.service.ITypeService;

@RestController(value = "typeAPIOfAdmin")
public class TypeAPI {
	
	@Autowired
	private ITypeService typeService;
	
	@PostMapping("/api/type")
	public TypeDTO createType(@RequestBody TypeDTO typeDTO) {		
		return typeService.save(typeDTO);
	}
	
	@PutMapping("/api/type")
	public TypeDTO updateType(@RequestBody TypeDTO typeDTO) {	
		return typeService.save(typeDTO);
	}
	
	@DeleteMapping("/api/type")
	public void deleteType(@RequestBody long[] ids) {
		typeService.delete(ids);
	}
}
