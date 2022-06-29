package com.co.pragma.serviceclientclean.infraestructure.entrypoints.api.models;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
	

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("type_document")
	@NotBlank
	private String typeDocument;

	@JsonProperty("number_document")
	@NotBlank
	private String numberDocument;

	@JsonProperty("age")
	private Integer age;

	@JsonProperty("birth_city")
	private String birthCity;

}
