package com.co.pragma.serviceclientclean.domain.model.gateways;

import java.util.List;
import java.util.Optional;

import com.co.pragma.serviceclientclean.domain.model.Client;


public interface ClientRepository {
	List<Client> getAllClients();
	
	Client createClient(Client client) ;
	
	Client getByTypeAndNumber(String typeDocument, String numberDocument);
	
	List<Client> getByAgeGreater (Integer age);
	
	Optional<Client>  findById(Long id);
	
	Client updateClient(Client client) ;
	
	Client disableClient(Client client);

}
