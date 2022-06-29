package com.co.pragma.serviceclientclean.infraestructure.driveradapters.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.pragma.serviceclientclean.domain.model.Client;

@Repository
public interface MySqlRepository extends JpaRepository<ClientEntity, Long>{
	
	@Transactional(readOnly = true)
	List<ClientEntity> findByStateIsTrue();
	
	@Transactional(readOnly = true)
	ClientEntity findByTypeDocumentAndNumberDocumentAndStateIsTrue(String typeDocument, String numberDocument);
	
	@Transactional(readOnly = true)
	List<ClientEntity> findByAgeGreaterThanEqual(Integer age);
	
	
}
