package com.watch.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.watch.dto.BrandDTO;
import com.watch.service.IBrandService;

@RestController(value = "brandAPIOfAdmin")
public class BrandAPI {
	
	@Autowired
	private IBrandService brandService;
	
	@PostMapping("/api/brand")
	public BrandDTO createBrand(@RequestBody BrandDTO brandDTO) {		
		return brandService.save(brandDTO);
	}
	
	@PutMapping("/api/brand")
	public BrandDTO updateBrand(@RequestBody BrandDTO brandDTO) {	
		return brandService.save(brandDTO);
	}
	
	@DeleteMapping("/api/brand")
	public void deleteBrand(@RequestBody long[] ids) {
		brandService.delete(ids);
	}
}
