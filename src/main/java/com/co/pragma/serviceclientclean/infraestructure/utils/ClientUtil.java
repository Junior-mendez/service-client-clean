package com.co.pragma.serviceclientclean.infraestructure.utils;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import lombok.experimental.UtilityClass;
@UtilityClass
public class ClientUtil {

	public static String convertFiletoBase64(MultipartFile file) {
		 byte[] bytes = null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     return Base64.getEncoder().encodeToString(bytes);
	}
}
