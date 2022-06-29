package com.co.pragma.serviceclientclean.domain.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.pragma.helpers.ClientHelper;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientCreateException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientDisableException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientNotFoundDocumentException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientNotFoundIdException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientUpdateException;
import com.co.pragma.serviceclientclean.domain.model.gateways.ClientRepository;
import com.co.pragma.serviceclientclean.domain.model.gateways.ImageService;

@ExtendWith(MockitoExtension.class)
class ClientUseCaseTest {


	@Mock
	ClientRepository clientRepository;
	
	
	@Mock
	ImageService imageService;
	

	@InjectMocks
	private	ClientUseCase clientUseCase;

	@Test
	 void testGetAllClients() {
		when(clientRepository.getAllClients()).thenReturn(ClientHelper.createListClients());

		assertEquals(1L,  clientUseCase.getAllClients().get(0).getId());
	}
	

	@Test
	 void testGetClientByTypeAndNumberDocumet() {
		when(clientRepository.getByTypeAndNumber(Mockito.anyString(), Mockito.anyString()))
		.thenReturn(ClientHelper.createClientDomain());
		when(imageService.getImage(Mockito.anyString())).thenReturn(ClientHelper.createImage());

		assertEquals(1L, clientUseCase.getByTypeAndNumer("DNI", "76515667").getId());
	}
	
	@Test
	 void testGetClientByTypeAndNumberDocumetFail() {
		when(clientRepository.getByTypeAndNumber(Mockito.anyString(), Mockito.anyString()))
		.thenReturn(null);
		assertThrows(ClientNotFoundDocumentException.class,
				()->{clientUseCase.getByTypeAndNumer("DNI", "76515667").getId();});
	}
	

	@Test
	 void testGetClientByAge() throws Exception {
		when(clientRepository.getByAgeGreater(Mockito.anyInt()))
		.thenReturn(ClientHelper.createListClients());

		
		assertEquals(1L,clientUseCase.getByAgeGreater(20).get(0).getId());
	}

	@Test
	 void testCreateClient() throws ClientCreateException {

		when(clientRepository.getByTypeAndNumber(Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		when(clientRepository.createClient(Mockito.any())).thenReturn(ClientHelper.createClientDomain());
		when(imageService.createImage(Mockito.any())).thenReturn(ClientHelper.createImage());

		assertEquals(1L,clientUseCase.createClient(ClientHelper.createClientDomainCreate())
		.getId());
	}

	
	@Test
	 void testCreateClientException() throws ClientCreateException {
		when(clientRepository.getByTypeAndNumber(Mockito.anyString(), Mockito.anyString())).thenReturn(ClientHelper.createClientDomain());
		assertThrows(ClientCreateException.class,
		()->{clientUseCase.createClient(ClientHelper.createClientDomainCreate());});
	}
	
	@Test
	 void testCreateClientFail() throws ClientCreateException {
		when(clientRepository.getByTypeAndNumber(Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		when(clientRepository.createClient(Mockito.any())).thenReturn(null);
		assertThrows(ClientCreateException.class,
		()->{clientUseCase.createClient(ClientHelper.createClientDomainCreate());});
	}
	

	@Test
	 void testUpdateClient() throws ClientCreateException {
		when(clientRepository.findById(Mockito.any())).thenReturn(Optional.of(ClientHelper.createClientDomain()));
		when(clientRepository.updateClient(Mockito.any())).thenReturn(ClientHelper.createClientDomain());
		when(imageService.updateImage(Mockito.any())).thenReturn(ClientHelper.createImage());

		assertEquals(1L,clientUseCase.updateClient(ClientHelper.createClientDomainUpdate(),1L)
		.getId());
	}
	
	@Test
	 void testUpdateClientFail() throws ClientUpdateException {
		when(clientRepository.findById(Mockito.any())).thenReturn(Optional.of(ClientHelper.createClientDomain()));
		when(clientRepository.updateClient(Mockito.any())).thenReturn(null);
	
		assertThrows(ClientUpdateException.class,
				()->{clientUseCase.updateClient(ClientHelper.createClientDomainUpdate(),1L);});
	}
	
//	@Test
//	 void testUpdateClientNotFound() {
//		when(clientRepository.findById(Mockito.any())).thenReturn(null);
//	
//		assertThrows(NullPointerException.class,
//				()->{clientUseCase.updateClient(ClientHelper.createClientDomainUpdate(),1L);});
//	}
	
	
	@Test
	void testDisableClient() throws Exception {
		when(clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ClientHelper.createClientDomain()));
		when(clientRepository.disableClient(Mockito.any())).thenReturn(ClientHelper.createClientDomain());

		clientUseCase.disableClient(1L);
	}
	
	@Test
	void testDisableClientFail() {
		when(clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ClientHelper.createClientDomain()));
		when(clientRepository.disableClient(Mockito.any())).thenReturn(null);

		assertThrows(ClientDisableException.class,
				()->{clientUseCase.disableClient(1L);});
	}
	
	@Test
	void testDisableClientNotFound() {
		when(clientRepository.findById(Mockito.anyLong())).thenReturn(null);

		assertThrows(NullPointerException.class,
				()->{clientUseCase.disableClient(1L);});
	}
	

}
