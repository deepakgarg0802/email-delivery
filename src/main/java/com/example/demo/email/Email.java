package com.example.demo.email;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Email")
public class Email {

	@Id
	@ApiModelProperty(value = "Email id on which mail has to be sent", required = true)
	private String email_id;
	
	@ApiModelProperty(value = "Subject of Mail", required = true)
	private String subject;
	
	@ApiModelProperty(value = "Body of Mail", required = true)
	private String body;
	
	@ApiModelProperty(value = "Sender of Mail", required = true)
	private String from;
	
	public Email() {
		
	}
	
	
	public Email(String emailId, String subject, String body, String from) {
		super();
		this.email_id = emailId;
		this.subject = subject;
		this.body = body;
		this.from = from;
	}
	
	
	public String getEmailId() {
		return email_id;
	}
	public void setEmailId(String emailId) {
		this.email_id = emailId;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String name) {
		this.subject = name;
	}
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String role) {
		this.body = role;
	}
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String address) {
		this.from = address;
	}
}
