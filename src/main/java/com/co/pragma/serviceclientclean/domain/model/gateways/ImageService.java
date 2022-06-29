package com.co.pragma.serviceclientclean.domain.model.gateways;

import java.util.Optional;

import com.co.pragma.serviceclientclean.domain.model.Image;

public interface ImageService {

	Optional<Image>  createImage(Image image);
	
	Optional<Image>  updateImage(Image image);
	
	Optional<Image> getImage(String id);
	
}
