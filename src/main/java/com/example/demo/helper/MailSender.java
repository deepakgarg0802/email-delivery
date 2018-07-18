/*
 * PEARSON PROPRIETARY AND CONFIDENTIAL INFORMATION SUBJECT TO NDA 
 * Copyright (c) 2017 Pearson Education, Inc.
 * All Rights Reserved. 
 * 
 * NOTICE: All information contained herein is, and remains the property of 
 * Pearson Education, Inc. The intellectual and technical concepts contained 
 * herein are proprietary to Pearson Education, Inc. and may be covered by U.S. 
 * and Foreign Patents, patent applications, and are protected by trade secret 
 * or copyright law. Dissemination of this information, reproduction of this  
 * material, and copying or distribution of this software is strictly forbidden   
 * unless prior written permission is obtained from Pearson Education, Inc.
 */
package com.example.demo.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
 
@Component("javasampleapproachMailSender")
public class MailSender {
  
  @Autowired
  JavaMailSender javaMailSender;
  
  Logger logger = LoggerFactory.getLogger(this.getClass());
  
  public void sendMail(String from, String to, String subject, String body) {
    
    SimpleMailMessage mail = new SimpleMailMessage();
 
    mail.setFrom(from);
    mail.setTo(to);
    mail.setSubject(subject);
    mail.setText(body);
    
    logger.info("Sending...");
    
    javaMailSender.send(mail);
    
    logger.info("Done!");
  }
}
