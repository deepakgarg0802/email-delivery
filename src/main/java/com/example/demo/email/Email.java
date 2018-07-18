package com.example.demo.email;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {

	@Id
	private String email_id;
	private String subject;
	private String body;
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
