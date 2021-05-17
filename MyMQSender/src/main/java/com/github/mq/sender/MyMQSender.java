package com.github.mq.sender;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.mq.connection.MyMQConnection;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

@Service
public class MyMQSender {
	private static final Logger logger = LoggerFactory.getLogger(MyMQSender.class);
	
	@Autowired
	private MyMQConnection myMQConnection;
	
	@Value("${myQueue}")
	private String myQueue;
	
	public MyMQSender() {
		logger.info("MyMQSender() invoked!!");
	}
	
	public void send(int i) throws JMSException {
	
		MQQueueConnection con = myMQConnection.getMQConnection();
		MQQueueSession session = myMQConnection.getMQSession(con);
		MQQueue queue = (MQQueue) session.createQueue(myQueue);
		MQQueueSender sender = (MQQueueSender) session.createSender(queue);
		String message = "Message "+i;
		TextMessage textMsg = session.createTextMessage(message);
		sender.send(textMsg);
	
	}
}
