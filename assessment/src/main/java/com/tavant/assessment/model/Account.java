package com.tavant.assessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "account")
public class Account {

	@Id
	@NotBlank(message = "Id must be associated to each account holder")
	private String accountId;
	
	@NotBlank(message = "Account Number cannot be null")
	@Min(0)
	private String accountNumber;
	
	@NotBlank(message = "Account Type cannot be null")
	@Column(length = 10)
	private String accountType;
	
	@NotBlank(message = "Account Holder First Name cannot be null")
	@Column(length = 15)
	private String firstName;
	
	@NotBlank(message = "Account Holder Last Name cannot be null")
	@Column(length = 15)
	private String lastName;
	
	@NotNull(message = "Please update the balance")
	private float balance;

	@Column(length=30)
	@NotBlank(message="Update Email Id for the bank account")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotBlank(message = "Address is mandatory")
	@Column(length = 30)
	private String address;
		
}
