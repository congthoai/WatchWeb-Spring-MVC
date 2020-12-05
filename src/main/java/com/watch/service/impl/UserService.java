package com.watch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.watch.converter.UserConverter;
import com.watch.dto.UserDTO;
import com.watch.entity.UserEntity;
import com.watch.repository.UserRepository;
import com.watch.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserConverter userConverter;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		
		for (UserEntity userEntity : entities) {
			result.add(userConverter.toDto(userEntity));
		}
		return result;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity userEntity : entities) {
			result.add(userConverter.toDto(userEntity));
		}
		return result;
	}

	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}

}
