package com.co.pragma.serviceclientclean.infraestructure.driveradapters.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("image")
	private String image;

}
