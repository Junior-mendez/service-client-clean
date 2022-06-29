package com.co.pragma.serviceclientclean.infraestructure.driveradapters.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "service-client-image", url = "${url.service-client-image}")
public interface ImageClient {
	
	@PostMapping(value = "/create")
	ImageDTO createClientImage(
			@RequestBody ImageDTO image);
	
	@PostMapping(value = "/update")
	ImageDTO updateClientImage(
			@RequestBody ImageDTO image);
	
	@GetMapping(value = "/{id}")
	ImageDTO getClientImage(
			@PathVariable String id);

}
