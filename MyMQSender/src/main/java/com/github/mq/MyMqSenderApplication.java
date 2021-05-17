package com.github.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.mq.sender.MyMQSender;

import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;

import org.slf4j.Logger;


@SpringBootApplication
public class MyMqSenderApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MyMqSenderApplication.class);

	@Autowired
	private MyMQSender myMQSender;
	
	public static void main(String[] args) throws JMSException {
		logger.info("My MQ Sender App started..");
		SpringApplication.run(MyMqSenderApplication.class, args);
	}
	
	
	  @PostConstruct 
	  public void sendMqMessages() throws JMSException{
		  logger.info("PostConstruct init() invoked..");
		  logger.info("sending messages..."); 
		  for(int i=0; i<100; i++)
			  myMQSender.send(i);
		  logger.info("messages sent!!"); 
	  }
	 

}
