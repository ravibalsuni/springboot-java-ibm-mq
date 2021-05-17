package com.github.mq.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;

import org.messaginghub.pooled.jms.JmsPoolConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.destination.BeanFactoryDestinationResolver;
import org.springframework.jms.support.destination.DestinationResolver;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.jms.internal.JmsPropertyContextImpl;
import com.ibm.msg.client.wmq.WMQConstants;

@EnableJms
@Configuration
public class MyMQConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(MyMQConfiguration.class);
	
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
	public MyMQConfiguration() {
		logger.info("MyMQConfiguration() invoked..!!");
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsFactory( ConnectionFactory cf, DefaultJmsListenerContainerFactoryConfigurer configurer){
		logger.info("jmsFactory() invoked..!");
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory= new DefaultJmsListenerContainerFactory();
		try {
			defaultJmsListenerContainerFactory.setConnectionFactory(mqConnetionFactory());
			defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(WMQConstants.CLIENT_ACKNOWLEDGE);
			defaultJmsListenerContainerFactory.setDestinationResolver(destinationResolver());
			defaultJmsListenerContainerFactory.setConcurrency("10-20");
			configurer.configure(defaultJmsListenerContainerFactory, cf);
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
				
		return defaultJmsListenerContainerFactory;
	}

	@Bean
	public DestinationResolver destinationResolver() {
		logger.info("destinationResolver() invoked..!!");
		return new BeanFactoryDestinationResolver() {
			@Override
			public Destination resolveDestinationName(Session session, String destinationName, boolean pubSubDomain)
					throws JMSException {
				Queue queue = session.createQueue(destinationName);
				if(queue instanceof JmsPropertyContextImpl) {
					JmsPropertyContextImpl contextImpl = (JmsPropertyContextImpl)queue;
					contextImpl.setIntProperty(WMQConstants.WMQ_TARGET_CLIENT, WMQConstants.WMQ_TARGET_DEST_MQ);
					contextImpl.setBooleanProperty(WMQConstants.WMQ_MQMD_READ_ENABLED, true);
					contextImpl.setBooleanProperty(WMQConstants.WMQ_MQMD_WRITE_ENABLED, true);
					contextImpl.setIntProperty(WMQConstants.WMQ_MQMD_MESSAGE_CONTEXT, WMQConstants.WMQ_MDCTX_SET_ALL_CONTEXT);
				}
				return queue;
			}
		};
	}

	@Bean
	@Primary
	public ConnectionFactory mqConnetionFactory() throws JMSException {
		logger.info("mqConnetionFactory() invoked..!!");
		MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
		connectionFactory.setHostName(hostname);
		connectionFactory.setPort(Integer.valueOf(port));
		connectionFactory.setChannel(channel);
		connectionFactory.setQueueManager(queueManager);
		connectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
		connectionFactory.setClientReconnectOptions(WMQConstants.WMQ_CLIENT_RECONNECT);
		connectionFactory.setClientReconnectTimeout(5000);
		connectionFactory.setStringProperty(WMQConstants.USERID, userId);
		connectionFactory.setStringProperty(WMQConstants.PASSWORD, password);

		
		JmsPoolConnectionFactory jmsPoolConnectionFactory = new JmsPoolConnectionFactory();
		jmsPoolConnectionFactory.setConnectionFactory(connectionFactory);
		jmsPoolConnectionFactory.setMaxConnections(50);
		
		
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
		cachingConnectionFactory.setTargetConnectionFactory(jmsPoolConnectionFactory);
		cachingConnectionFactory.setSessionCacheSize(100);
		cachingConnectionFactory.setCacheProducers(true);
		cachingConnectionFactory.setCacheConsumers(true);
		cachingConnectionFactory.setReconnectOnException(true);
		cachingConnectionFactory.setExceptionListener(null);
		return cachingConnectionFactory;
	}
}
