package com.imed.app.ws.requests;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {
	
	//@valid fel controller pour valider ces condition
	@NotBlank(message = "Ce Champs Ne doit etre null !")
	@NotEmpty(message = "Ce Champs Ne doit etre null !")
	@NotNull(message = "Ce Champs Ne doit etre null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caractere !")
	private String firstname;
	@NotBlank(message = "Ce Champs Ne doit etre null !")
	@NotEmpty(message = "Ce Champs Ne doit etre null !")
	@NotNull(message = "Ce Champs Ne doit etre null")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caractere !")
	private String lastname;
	@NotNull(message = "Ce Champs Ne doit etre null !")
	@Email(message = "Ce champs doit respecter le format email !")
	private String email;
	private Boolean admin;
	@NotBlank(message = "Ce Champs Ne doit etre null !")
	@NotEmpty(message = "Ce Champs Ne doit etre null !")
	@NotNull(message = "Ce Champs Ne doit etre null !")
	@Size(min = 8,message = "mot de passe doit avoir au minimum 8 caractere !")
	@Size(max = 12,message = "mot de passe doit avoir au max 12 caractere !")
	//pour verifier le mot de passe a des uppercase lower case
	@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",message="Mot de passe doit avoir des lettres maj et des lettre miniscule")
	private String password;
	
	private List<AdressRequest> addresses ;
	
	private ContactRequest contact;
	
	
	
	//Getters and Setters
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AdressRequest> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AdressRequest> addresses) {
		this.addresses = addresses;
	}
	public ContactRequest getContact() {
		return contact;
	}
	public void setContact(ContactRequest contact) {
		this.contact = contact;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	

}
