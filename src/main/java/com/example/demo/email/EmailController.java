package com.example.demo.email;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.MailSender;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class EmailController {

	Map<String,Integer> count=new HashMap<String, Integer>();
	@Autowired
	private EmailService myService;

	@Autowired
	public MailSender mailSender;

	@RequestMapping(value="/hello",method=RequestMethod.GET,
			produces=MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Hello", notes = "Hello", response = String.class)
	public String getmy(){
		return "Hello";
	}

	@RequestMapping(value="/mail", method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Send Mail", notes = "Send Mail", response = String.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = String.class),
        @ApiResponse(code = 400, message = "Bad request", response = String.class)
    })
	public String getmymail(@RequestBody Email email){

		String from= email.getFrom();
		String body=email.getBody();
		String emailId= email.getEmailId();
		String subject=email.getSubject();
		mailSender.sendMail(from, emailId, subject, body);
		count.put(emailId, count.getOrDefault(emailId, 0) + 1);

		return "Mail Sent..";
	}

	@RequestMapping(value="/mail/{Emailid}/count", method=RequestMethod.GET,
			produces= MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Get Count", notes = "Get Count", response = Integer.class)
	public int getMailsCount(@PathVariable("Emailid") String id) {
		if(count.containsKey(id))
			return count.get(id);
		return 0;
	}

}
