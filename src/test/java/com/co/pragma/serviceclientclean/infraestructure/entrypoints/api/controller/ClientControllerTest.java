package com.co.pragma.serviceclientclean.infraestructure.entrypoints.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.co.pragma.helpers.ClientHelper;
import com.co.pragma.serviceclientclean.domain.model.Client;
import com.co.pragma.serviceclientclean.domain.usecase.ClientUseCase;
import com.co.pragma.serviceclientclean.infraestructure.driveradapters.mappers.ClientMapper;
import com.co.pragma.serviceclientclean.infraestructure.entrypoints.api.models.ClientRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
@WebMvcTest(ClientController.class)
class ClientControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	private ClientUseCase clientUseCase;
	
	@MockBean
	private ClientMapper clientMapper;
	
	
    static ObjectMapper om = new ObjectMapper();
	@BeforeEach
	  public void setUp() throws Exception {
	    om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    JacksonTester.initFields(this, om);
	  }

	@Test
	void testallClients() throws Exception {
		when(clientUseCase.getAllClients()).thenReturn(ClientHelper.createListClients());
		
		 mockMvc
	        .perform(
	            get("/client/all"))
	        .andDo(print())
	        .andExpect(status().isOk());
		
	}
	
	@Test
	void testClientByTypeAndNumber() throws Exception {
		when(clientUseCase.getByTypeAndNumer(Mockito.anyString(), Mockito.anyString())).thenReturn(ClientHelper.createClientDomain());
		
		 mockMvc
	        .perform(
	            get("/client/document")
	            .param("typeDocument", "DNI")
	            .param("numberDocument", "76515667"))
	        .andDo(print())
	        .andExpect(status().isOk());
		
	}
	@Test
	void testcreateClient() throws Exception {
		byte[] byteContent1 = "text1".getBytes(StandardCharsets.US_ASCII);

		MockMultipartFile filePart1 = new MockMultipartFile("image", "file1.txt", "text/plain", byteContent1);
		ClientRequest clientRequest = ClientHelper.createClientRequest();
		Client clientDomain = ClientHelper.createClientDomainOfRequest();
		when(clientUseCase.createClient(clientDomain)).thenReturn(clientDomain);
		
		 mockMvc
	        .perform(
	        		 multipart("/client/create")
	  	           .file(filePart1)
	  	         .param("typeDocument", clientRequest.getTypeDocument())
		         .param("numberDocument", clientRequest.getNumberDocument())
	            )
	        .andDo(print())
	        .andExpect(status().isOk());
		
	}
	
	@Test
	void testUpdateClient() throws Exception {
		byte[] byteContent1 = "text1".getBytes(StandardCharsets.US_ASCII);

		MockMultipartFile filePart1 = new MockMultipartFile("image", "file1.txt", "text/plain", byteContent1);
		ClientRequest clientRequest = ClientHelper.createClientRequest();
		Client clientDomain = ClientHelper.createClientDomainOfRequest();
		when(clientUseCase.updateClient(clientDomain,11L)).thenReturn(clientDomain);
		
		 mockMvc
	        .perform(
	           multipart("/client/update/11")
	           .file(filePart1)
	           .param("typeDocument", clientRequest.getTypeDocument())
		         .param("numberDocument", clientRequest.getNumberDocument()))
	        .andDo(print())
	        .andExpect(status().isOk());
		
	}
	
	@Test
	void testDisableClient() throws Exception {

		 mockMvc
	        .perform(
	            put("/client/disable/{id}",11L))
	        .andDo(print())
	        .andExpect(status().isOk());
		
	}
	
	@Test
	void testClientByAge() throws Exception {
		when(clientUseCase.getByAgeGreater(Mockito.any())).thenReturn(ClientHelper.createListClients());
		
		 mockMvc
	        .perform(
	            get("/client/age")
	            .param("age","20"))
	        .andDo(print())
	        .andExpect(status().isOk());
		
	}

}
