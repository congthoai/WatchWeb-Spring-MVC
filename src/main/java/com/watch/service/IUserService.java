package com.watch.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.watch.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
	List<UserDTO> findAll(Pageable pageable);
	int getTotalItem();

}
