package com.nitendragautam.bankingapp.model;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;





import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author nitendra
 *
 */


@Entity
@Table(name ="BankAccount") 
public class BankAccount implements Serializable{
	private static final long serialVersionUID = 42L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="phone_number")
	private Integer phoneNumber;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="residental_address")
	private String residentalAddress;
	
	@Column(name="account_balance")
	private double currentAccountBalance;
	
	//Creating default date&time for date columns
	@CreationTimestamp
	@Column(name="opening_date", updatable=false)
	private Date openingDate;
	
	//Creating default date&time for date columns
	@UpdateTimestamp
	@Column(name="modified_date")
	private Date modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getResidentalAddress() {
		return residentalAddress;
	}

	public void setResidentalAddress(String residentalAddress) {
		this.residentalAddress = residentalAddress;
	}

	public double getCurrentAccountBalance() {
		return currentAccountBalance;
	}

	public void setCurrentAccountBalance(double currentAccountBalance) {
		this.currentAccountBalance = currentAccountBalance;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	
	
	
	
}