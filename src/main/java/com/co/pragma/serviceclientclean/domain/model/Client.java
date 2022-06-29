package com.co.pragma.serviceclientclean.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
private Long id;
	
	private String name;
	
	private String lastname;
	
	private String typeDocument;
	
	private String numberDocument;
	
	private Integer age;
	
	private String birthCity;
	
	private Boolean state;
	
	private MultipartFile image;
	
	private String imageBase64;
	
	public ClientBuilder adapted() {
        return Client.builder()
                .id(id)
                .name(name)
                .lastname(lastname)
                .typeDocument(typeDocument)
                .age(age)
                .numberDocument(numberDocument)
                .birthCity(birthCity)
                .state(state)
                .imageBase64(imageBase64);
    }
}
