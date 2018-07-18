package com.example.demo.email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	List<Email> mylist= new ArrayList<Email>(Arrays.asList(new Email("3", "a", "Manager", "address"),
			new Email("2", "b", "Email", "address")));
			
	public List<Email> getAllEmails() {
		ArrayList<Email> arrayList= new ArrayList<>();
		
		emailRepository.findAll().forEach(arrayList::add);
		return arrayList;
	}
	
	public Email getEmail(String id) {
		//return mylist.stream().filter(t->t.getEmpId()==id).findFirst().get();
		return emailRepository.findOne(id);
	}
	
	public int addEmail(Email email) {
		long count=emailRepository.count();
		emailRepository.save(email);
		if(emailRepository.count()== count+1) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
