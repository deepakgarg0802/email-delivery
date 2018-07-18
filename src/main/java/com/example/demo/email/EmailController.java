package com.example.demo.email;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.MailSender;


@RestController
public class EmailController {

	Map<String,Integer> count=new HashMap<String, Integer>();
	@Autowired
	private EmailService myService;

	@Autowired
	public MailSender mailSender;

	@RequestMapping("/hello")
	public String getmy(){
		return "Hello";
	}

	@RequestMapping(value="/mail", method=RequestMethod.POST)
	public String getmymail(@RequestBody Map<String, String> json){

		String from= json.get("from");
		String body=json.get("body");
		String to= json.get("to");
		String subject=json.get("subject");
		mailSender.sendMail(from, to, subject, body);
		count.put(to, count.getOrDefault(to, 0) + 1);

		return "Mail Sent..";
	}

	@RequestMapping("/mail/{Emailid}/count")
	public int getMailsCount(@PathVariable("Emailid") String id) {
		if(count.containsKey(id))
			return count.get(id);
		return 0;
	}

}
