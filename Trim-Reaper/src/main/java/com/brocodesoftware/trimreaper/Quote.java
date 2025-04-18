package com.brocodesoftware.trimreaper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "quote")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String quoteNumber;
	
	private String name;
	private String email;
	private String address;
	
	private String requestedServices;
	private String status;
	
	private LocalDateTime dateRequested;
	private LocalDate scheduledDate;
	

	
	// GETTERS //
	
	public Long getId() {
		return id;
	}
	
	public String getQuoteNumber() {
		return quoteNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getRequestedServices() {
		return requestedServices;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDateTime getDateRequested() {
		return dateRequested;
	}
	
	public LocalDate getScheduledDate() {
		return scheduledDate;
	}
	
	
	// SETTERS //
	public void setId(long id) {
		this.id = id;
	}
	
	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setRequestedServices(String requestedServices) {
		this.requestedServices = requestedServices;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDateRequested(LocalDateTime dateRequested) {
		this.dateRequested = dateRequested;
	}
	
	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}	
}

