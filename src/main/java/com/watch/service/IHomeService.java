package com.watch.service;

import java.util.Map;

import com.watch.dto.MenuDTO;

public interface IHomeService {
	Map<String, MenuDTO> loadMenu();
}	