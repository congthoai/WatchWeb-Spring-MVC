package com.watch.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.watch.dto.RoleDTO;
import com.watch.dto.UserDTO;
import com.watch.entity.RoleEntity;
import com.watch.entity.UserEntity;

@Component
public class UserConverter {
	
	@Autowired
	RoleConverter roleConverter;
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		List<RoleDTO> roles = new ArrayList<>();
		result.setUserName(entity.getUserName());
		result.setFullName(entity.getFullName());
		result.setPassword(entity.getPassword());
		result.setPhone(entity.getPhone());
		result.setEmail(entity.getEmail());
		
		for (RoleEntity role : entity.getRoles()) {
			roles.add(roleConverter.toDto(role));
		}
		
		result.setRoles(roles);
		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setFullName(dto.getFullName());
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setPhone(dto.getPhone());
		result.setEmail(dto.getEmail());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setFullName(dto.getFullName());
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setPhone(dto.getPhone());
		result.setEmail(dto.getEmail());
		return result;
	}
	

}
