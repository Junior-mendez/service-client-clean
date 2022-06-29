package com.co.pragma.serviceclientclean.infraestructure.driveradapters.mappers;

import org.mapstruct.Mapper;

import com.co.pragma.serviceclientclean.domain.model.Image;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.api.ImageDTO;

@Mapper(componentModel = "spring")
public interface ImageMapper {
	
	Image imageDTOtoImage(ImageDTO imageDTO);
	
	ImageDTO imagetoImageDTO(Image image);

}
