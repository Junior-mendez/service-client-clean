package com.co.pragma.serviceclientclean.domain.usecase;

import java.util.List;
import java.util.Optional;

import com.co.pragma.serviceclientclean.domain.exceptions.ClientCreateException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientDisableException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientNotFoundDocumentException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientNotFoundIdException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientUpdateException;
import com.co.pragma.serviceclientclean.domain.model.Client;
import com.co.pragma.serviceclientclean.domain.model.Image;
import com.co.pragma.serviceclientclean.domain.model.gateways.ClientRepository;
import com.co.pragma.serviceclientclean.domain.model.gateways.ImageService;
import com.co.pragma.serviceclientclean.infraestructure.utils.ClientUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ClientUseCase {
	
	private final ClientRepository clientRepository;
	
	private final ImageService imageService;


	public List<Client> getAllClients() {
		log.info("ClientService-->getAllClients");
		return clientRepository.getAllClients();
	}


	public Client createClient(Client client) throws ClientCreateException {
		log.info("ClientService-->createClient");
		
		if(Optional.ofNullable(clientRepository.getByTypeAndNumber(client.getTypeDocument(), client.getNumberDocument()))
				.isPresent()){
			throw new ClientCreateException(client);
		}
		return Optional.ofNullable(clientRepository.createClient(client))
				.flatMap(clientSaved -> imageService.createImage(
						new Image(
								client.getTypeDocument().concat(client.getNumberDocument()),
								ClientUtil.convertFiletoBase64(client.getImage())))
				.map(image -> clientSaved.adapted().imageBase64(image.getImage()).build()))
				.orElseThrow(()->new ClientCreateException(client));

	}


	public Client getByTypeAndNumer(String typeDocument, String numberDocument) {
		log.info("ClientService-->getByTypeAndNumer");
		 return Optional.ofNullable(clientRepository.getByTypeAndNumber(typeDocument, numberDocument))
				 .flatMap(client -> imageService.getImage(typeDocument.concat(numberDocument))
				 .map(image -> client.adapted().imageBase64(image.getImage()).build()))
				 .orElseThrow(()->new ClientNotFoundDocumentException(typeDocument, numberDocument));		
	}
	

	public Client updateClient(Client client, Long id)  throws ClientUpdateException{
		log.info("ClientService-->updateClient");
		clientRepository.findById(id);
		client.setId(id);
		
		return Optional.ofNullable(clientRepository.updateClient(client))
				 .flatMap(clientUpdated -> imageService.updateImage(
							new Image(
									clientUpdated.getTypeDocument().concat(clientUpdated.getNumberDocument()),
									ClientUtil.convertFiletoBase64(client.getImage())))
				.map(image -> clientUpdated.adapted().imageBase64(image.getImage()).build()))
				.orElseThrow(()->new ClientUpdateException(client));
	}


	public void disableClient(Long id) throws Exception {
		log.info("ClientService-->disableClient");
		Client client =clientRepository.findById(id).orElseThrow(NullPointerException::new);
		client.setState(false);
		Optional.ofNullable(clientRepository.disableClient(client))
		.orElseThrow(()->new ClientDisableException(id)) ;

	}


	public List<Client> getByAgeGreater(Integer age) throws Exception {
		return Optional.ofNullable(clientRepository.getByAgeGreater(age))
				.orElseThrow(Exception::new);
	}
}
