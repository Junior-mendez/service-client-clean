package com.co.pragma.serviceclientclean.infraestructure.driveradapters.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.pragma.serviceclientclean.domain.model.Image;
import com.co.pragma.serviceclientclean.domain.model.gateways.ImageService;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.mappers.ImageMapper;

@Component
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageClient imageClient;
	
	@Autowired
	private ImageMapper imageMapper;

	@Override
	public Optional<Image> createImage(Image image) {
		return Optional.of(imageMapper.imageDTOtoImage(imageClient.createClientImage(imageMapper.imagetoImageDTO(image))));
	}

	@Override
	public Optional<Image> updateImage(Image image) {
		return Optional.of(imageMapper.imageDTOtoImage(imageClient.updateClientImage(imageMapper.imagetoImageDTO(image))));
	}

	@Override
	public Optional<Image> getImage(String id) {
		return Optional.of(imageMapper.imageDTOtoImage(imageClient.getClientImage(id)));
	}

}
