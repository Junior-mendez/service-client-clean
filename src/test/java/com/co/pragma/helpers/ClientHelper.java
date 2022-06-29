package com.co.pragma.helpers;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.springframework.mock.web.MockMultipartFile;

import com.co.pragma.serviceclientclean.domain.model.Client;
import com.co.pragma.serviceclientclean.domain.model.Image;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.api.ImageDTO;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.mysql.ClientEntity;
import com.co.pragma.serviceclientclean.infraestructure.entrypoints.api.models.ClientRequest;



public class ClientHelper {
	
	public static List<Client> createListClients(){
		return List.of(createClientDomain());
	}
	
	public static List<ClientEntity> createListClientsEntity(){
		return List.of(createClientEntity());
	}

	public static Client createClientDomain(){
		return  Client.builder().id(1L).name("Junior")
				.lastname("Mendez")
				.typeDocument("DNI")
				.numberDocument("76515669")
				.age(26).build();
	}
	public static Client createClientDomainCreate(){
		byte[] byteContent1 = "text1".getBytes(StandardCharsets.US_ASCII);
		MockMultipartFile filePart1 = new MockMultipartFile("image", "file1.txt", "text/plain", byteContent1);
		return  Client.builder().name("Junior")
				.lastname("Mendez")
				.typeDocument("DNI")
				.numberDocument("76515669")
				.image(filePart1)
				.age(26).build();
	}
	
	public static Client createClientDomainUpdate(){
		byte[] byteContent1 = "text1".getBytes(StandardCharsets.US_ASCII);
		MockMultipartFile filePart1 = new MockMultipartFile("image", "file1.txt", "text/plain", byteContent1);
		return  Client.builder().name("Junior")
				.lastname("Mendez")
				.typeDocument("DNI")
				.numberDocument("76515669")
				.image(filePart1)
				.age(26).build();
	}
	
	public static ClientEntity createClientEntity(){
		return  ClientEntity.builder().id(1L).name("Junior")
				.lastname("Mendez")
				.typeDocument("DNI")
				.numberDocument("76515669")
				.age(26).build();
	}
	
	public static ClientRequest createClientRequest(){
		return  ClientRequest.builder()
				.name("Junior")
						.lastname("Mendez")
						.typeDocument("DNI")
						.numberDocument("76515669")
						.age(26)
				.build();
	}
	
	public static Client createClientDomainOfRequest(){
		return  Client.builder().name("Junior")
				.lastname("Mendez")
				.typeDocument("DNI")
				.numberDocument("76515669")
				.age(26).build();
	}
	
	public static Optional<Image> createImage(){
		return  Optional.of(Image.builder()
				.id("DNI76515669")
				.image("fsdfsdfdsf").build());
	}

}
