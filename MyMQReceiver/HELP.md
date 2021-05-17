# Listening Messages via MQ Receiver / MQ Listener

This Springboot application receives/listens messages from local queue - "DEV.QUEUE.1" forever.

# Following Properties are used in application.properties file (please modify as per your requirement)

hostname=ubuntu-pc
port=1414
queueManager=QM1
channel=DEV.APP.SVRCONN
userId=app
password=app
myQueue=DEV.QUEUE.1

# Please note MQ objects were created using instruction mentioned in Step 1 of below README.md file :

https://github.com/ravibalsuni/springboot-java-ibm-mq/blob/master/README.md


# Just run as Java Application

# Main File

MyMqReceiverApplication.java

# logs on eclipse console


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.3.10.RELEASE)

2021-05-17 23:08:31.525  INFO 471 --- [           main] com.github.mq.MyMqReceiverApplication    : Starting MyMqReceiverApplication on ubuntu-pc with PID 471 (/home/ravi/Desktop/Applications/eclipse/jee-2020-03/eclipse/this.workspace/MyMQReceiver/target/classes started by ravi in /home/ravi/Desktop/Applications/eclipse/jee-2020-03/eclipse/this.workspace/MyMQReceiver)
2021-05-17 23:08:31.528  INFO 471 --- [           main] com.github.mq.MyMqReceiverApplication    : No active profile set, falling back to default profiles: default
2021-05-17 23:08:32.216  INFO 471 --- [           main] c.g.mq.configuration.MyMQConfiguration   : MyMQConfiguration() invoked..!!
2021-05-17 23:08:32.235  INFO 471 --- [           main] com.github.mq.listner.MyMQListner        : MyMQReceiver() invoked!!
2021-05-17 23:08:32.263  INFO 471 --- [           main] c.g.mq.configuration.MyMQConfiguration   : mqConnetionFactory() invoked..!!
2021-05-17 23:08:32.520  INFO 471 --- [           main] o.m.pooled.jms.JmsPoolConnectionFactory  : Provided ConnectionFactory implementation is JMS 2.0+ capable.
2021-05-17 23:08:32.578  INFO 471 --- [           main] c.g.mq.configuration.MyMQConfiguration   : destinationResolver() invoked..!!
2021-05-17 23:08:32.581  INFO 471 --- [           main] c.g.mq.configuration.MyMQConfiguration   : jmsFactory() invoked..!
2021-05-17 23:08:32.743  INFO 471 --- [           main] com.github.mq.MyMqReceiverApplication    : Started MyMqReceiverApplication in 1.69 seconds (JVM running for 2.168)
Message 3
Message 1
Message 4
Message 2
Message 8
Message 5
Message 7
Message 9
Message 0
Message 6
Message 10
Message 11
Message 12
Message 13
Message 15
Message 14
Message 17
Message 21
Message 16
Message 22
Message 18
Message 23
Message 19
Message 20
Message 24
Message 26
Message 25
Message 27
Message 28
Message 30
Message 31
Message 29
Message 33
Message 34
Message 32
Message 37
Message 36
Message 35
Message 38
Message 39
Message 40
Message 41
Message 42
Message 43
Message 45
Message 46
Message 44
Message 47
Message 49
Message 48
Message 51
Message 52
Message 55
Message 50
Message 56
Message 53
Message 54
Message 57
Message 58
Message 59
Message 60
Message 62
Message 61
Message 63
Message 64
Message 66
Message 65
Message 67
Message 74
Message 68
Message 69
Message 73
Message 72
Message 70
Message 71
Message 75
Message 78
Message 79
Message 77
Message 76
Message 81
Message 82
Message 80
Message 83
Message 85
Message 87
Message 86
Message 84
Message 91
Message 92
Message 94
Message 95
Message 93
Message 88
Message 96
Message 90
Message 89
Message 97
Message 99
Message 98


# terminate the application otherwise it will be running forever :p

kill -9 471

or

via eclipse
