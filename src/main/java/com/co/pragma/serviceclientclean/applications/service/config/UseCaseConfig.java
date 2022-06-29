package com.co.pragma.serviceclientclean.applications.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.pragma.serviceclientclean.domain.model.gateways.ClientRepository;
import com.co.pragma.serviceclientclean.domain.model.gateways.ImageService;
import com.co.pragma.serviceclientclean.domain.usecase.ClientUseCase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	ClientUseCase getClientUseCase(ClientRepository clientRepository, ImageService imageService) {
		
		return new ClientUseCase(clientRepository,imageService);
	}

}
