package com.co.pragma.serviceclientclean.infraestructure.driveradapters.mysql;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idclient")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "type_document",nullable = false)
	private String typeDocument;
	
	@Column(name = "number_document",nullable = false)
	private String numberDocument;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "birth_city")
	private String birthCity;
	
	@Column(name = "state",nullable = false)
	private Boolean state;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@PrePersist
	public void createdAt() {
		this.createdAt=new Date();		
	}
	@PreUpdate
	public void updateAt() {
		this.updatedAt=new Date();		
	}
}
