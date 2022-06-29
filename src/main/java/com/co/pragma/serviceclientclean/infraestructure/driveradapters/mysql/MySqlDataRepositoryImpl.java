package com.co.pragma.serviceclientclean.infraestructure.driveradapters.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.pragma.serviceclientclean.domain.model.Client;
import com.co.pragma.serviceclientclean.domain.model.gateways.ClientRepository;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.mappers.ClientMapper;

@Component
public class MySqlDataRepositoryImpl implements ClientRepository {
	

	@Autowired
	private MySqlRepository mySqlRepository;
	
	@Autowired
	private ClientMapper clientMapper;
	
	@Override
	public List<Client> getAllClients() {
		
		return clientMapper.clientsEntityToClientsDomain(mySqlRepository.findByStateIsTrue());  
	}


	@Override
	public Client getByTypeAndNumber(String typeDocument, String numberDocument) {
		
		return clientMapper.clientEntityToClientDomain(mySqlRepository.findByTypeDocumentAndNumberDocumentAndStateIsTrue(typeDocument, numberDocument));
	}


	@Override
	public Client createClient(Client client)  {
		return clientMapper.clientEntityToClientDomain(mySqlRepository.save(clientMapper.clientDomainToClientEntity(client)));
	}


	@Override
	public Optional<Client> findById(Long id) {
		return mySqlRepository.findById(id)
				.map(clientMapper::clientEntityToClientDomain);
	}


	@Override
	public Client updateClient(Client client) {
		return clientMapper.clientEntityToClientDomain(mySqlRepository.save(clientMapper.clientDomainToClientEntity(client)));
	}


	@Override
	public Client disableClient(Client client) {
		
		return clientMapper.clientEntityToClientDomain(mySqlRepository.save(clientMapper.clientDomainToClientEntity(client)));
		
	}


	@Override
	public List<Client> getByAgeGreater(Integer age) {
		
		return clientMapper.clientsEntityToClientsDomain(mySqlRepository.findByAgeGreaterThanEqual(age));
	}


	
	
	

}
