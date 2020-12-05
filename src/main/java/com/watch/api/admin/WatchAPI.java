package com.watch.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.watch.dto.WatchDTO;
import com.watch.service.IWatchService;

@RestController(value = "watchAPIOfAdmin")
public class WatchAPI {
	
	@Autowired
	private IWatchService watchService;
	
	@PostMapping("/api/watch")
	public WatchDTO createWatch(@RequestBody WatchDTO watchDTO) {		
		return watchService.save(watchDTO);
	}
	
	@PutMapping("/api/watch")
	public WatchDTO updateWatch(@RequestBody WatchDTO watchDTO) {	
		return watchService.save(watchDTO);
	}
	
	@DeleteMapping("/api/watch")
	public void deleteWatch(@RequestBody long[] ids) {
		watchService.delete(ids);
	}
}
