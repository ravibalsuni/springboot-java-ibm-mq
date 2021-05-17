package com.github.mq.connection;

import javax.jms.JMSException;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSession;
import com.ibm.msg.client.wmq.WMQConstants;

@Component
public class MyMQConnection {
	
	private static final Logger logger = LoggerFactory.getLogger(MyMQConnection.class);

	@Value("${hostname}")
	private String hostname;
	
	@Value("${port}")
	private String port;
	
	@Value("${queueManager}")
	private String queueManager;
	
	@Value("${channel}")
	private String channel;
	
	@Value("${userId}")
	private String userId;
	
	@Value("${password}")
	private String password;
	
	public MyMQConnection() {
		logger.info("MyMQConnection() invoked!!"); 
	}
	
	private MQQueueConnection connection = null;
	private MQQueueSession session = null;
	
	public MQQueueConnection getMQConnection() throws JMSException {
		MQQueueConnectionFactory cf = new MQQueueConnectionFactory();
		cf.setHostName(hostname);
		cf.setPort(Integer.valueOf(port));
		cf.setTransportType(WMQConstants.WMQ_CM_CLIENT);
		cf.setQueueManager(queueManager);
		cf.setChannel(channel);
		connection = (MQQueueConnection)cf.createQueueConnection(userId, password);
		return connection;
	}
	
	public MQQueueSession getMQSession(MQQueueConnection connection) throws JMSException {
		connection.start();
		session = (MQQueueSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session;
	}
	
	public void closeMQSession() throws JMSException {
		session.clear();
		session.close();
	}
	
	public void closeMQConnection() throws JMSException {
		connection.clear();
		connection.close();
	}
	
	
}
