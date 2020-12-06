package com.watch.util;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MediaFileUtil {
	
	public String uploadMediFile(MultipartFile file, String rootPath) {
		try {
			if(file.isEmpty()) {
				System.out.println("File NULL");
			}else {
				String fileName = file.getOriginalFilename();
				file.transferTo(new File(rootPath+"/"+fileName));		
				System.out.println("Upload file thành công!"+ fileName);
				return fileName;
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Upload file thất bại!");
		}
		return null;
	}
}
