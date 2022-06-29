package com.co.pragma.serviceclientclean.infraestructure.driveradapters.mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import com.co.pragma.serviceclientclean.domain.model.Client;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.mysql.ClientEntity;
import com.co.pragma.serviceclientclean.infraestructure.entrypoints.api.models.ClientRequest;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	
	@Mapping(source = "client.state",target = "state", defaultValue = "true")
	ClientEntity clientDomainToClientEntity (Client client);
	
	
	List<Client> clientsEntityToClientsDomain(List<ClientEntity> clients);

	Client clientEntityToClientDomain (ClientEntity clientEntity);
	
	Client clientEntityOptionalToClientDomain (Optional<ClientEntity> clientEntity);
	
	@Mapping(source = "clientRequest.name",target ="name" )
	@Mapping(source = "clientRequest.lastname",target ="lastname" )
	@Mapping(source = "clientRequest.typeDocument",target ="typeDocument" )
	@Mapping(source = "clientRequest.numberDocument",target ="numberDocument" )
	@Mapping(source = "clientRequest.age",target ="age" )
	@Mapping(source = "clientRequest.birthCity",target ="birthCity" )
	@Mapping(source = "image",target ="image")
	Client clientRequesttoClientDomainImage(ClientRequest clientRequest, MultipartFile image);
	
	@Mapping(source = "clientRequest.name",target ="name" )
	@Mapping(source = "clientRequest.lastname",target ="lastname" )
	@Mapping(source = "clientRequest.typeDocument",target ="typeDocument" )
	@Mapping(source = "clientRequest.numberDocument",target ="numberDocument" )
	@Mapping(source = "clientRequest.age",target ="age" )
	@Mapping(source = "clientRequest.birthCity",target ="birthCity" )
	Client clientRequesttoClientDomain(ClientRequest clientRequest);

}
