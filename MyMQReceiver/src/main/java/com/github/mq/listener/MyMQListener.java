package com.github.mq.listener;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.jms.JMSBytesMessage;
import com.ibm.jms.JMSTextMessage;

@Service
public class MyMQListener implements JmsListenerConfigurer{
	private static final Logger logger = LoggerFactory.getLogger(MyMQListener.class);
	
	@Autowired(required = true)
	@Qualifier("jmsFactory")
	private JmsListenerContainerFactory<DefaultMessageListenerContainer> jmsListenerContainerFactory;
	
	private JmsListenerEndpointRegistrar jmsListenerEndpointRegistrar;
	
	@Value("${myQueue}")
	private String myQueue;
	
	public MyMQListener() {
		logger.info("MyMQReceiver() invoked!!");
	}
	
	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		this.jmsListenerEndpointRegistrar = registrar;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void registerJmsListnerEndpoint() {
		SimpleJmsListenerEndpoint simpleJmsListenerEndpoint = new SimpleJmsListenerEndpoint();
		String queuename = myQueue;
		simpleJmsListenerEndpoint.setId(queuename);;
		simpleJmsListenerEndpoint.setDestination(queuename );
		simpleJmsListenerEndpoint.setMessageListener(listenMessage());
		jmsListenerEndpointRegistrar.registerEndpoint(simpleJmsListenerEndpoint, jmsListenerContainerFactory);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 1000)
	private MessageListener listenMessage() {
		return message ->{
			logMessage(message);
			try {
				message.acknowledge();
			} catch (JMSException e) {
				try {
					message.acknowledge();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		};
	}

	private void logMessage(Message message) {
		String srcMessage = null;
		try {
			if(message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage)message;
				srcMessage = textMessage.getText();
			}
			else if(message instanceof JMSTextMessage) {
				JMSTextMessage jmstextMessage = (JMSTextMessage)message;
				srcMessage = jmstextMessage.getText();
			}
			else if(message instanceof JMSBytesMessage) {
				((JMSBytesMessage) message).reset();
				BytesMessage messageByte = (BytesMessage)message;
				int textLength = (int)messageByte.getBodyLength();
				byte[] textBytes = new byte[textLength];
				messageByte.readBytes(textBytes,textLength);
				srcMessage = new String(textBytes);
			}
			else {
				
			}
		} catch (Exception e) {
					
		}
		
		logger.info(srcMessage);
	}
	
}
