# Sending Messages via MQ Sender

This Springboot application sends messages on local queue - "DEV.QUEUE.1"

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

# Import Maven Project in Eclipse, Right Click on Eclipse Project MyMQSender, Run As Maven install

# Right Click MyMqSenderApplication.java, Run As -> Java Application

# sample logs on eclipse console

23:05:28.450 [main] INFO com.github.mq.MyMqSenderApplication - My MQ Sender App started..

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.3.10.RELEASE)

2021-05-17 23:05:29.086  INFO 32312 --- [           main] com.github.mq.MyMqSenderApplication      : Starting MyMqSenderApplication on ubuntu-pc with PID 32312 (/home/ravi/Desktop/Applications/eclipse/jee-2020-03/eclipse/this.workspace/MyMQSender/target/classes started by ravi in /home/ravi/Desktop/Applications/eclipse/jee-2020-03/eclipse/this.workspace/MyMQSender)
2021-05-17 23:05:29.088  INFO 32312 --- [           main] com.github.mq.MyMqSenderApplication      : No active profile set, falling back to default profiles: default
2021-05-17 23:05:29.789  INFO 32312 --- [           main] com.github.mq.sender.MyMQSender          : MyMQSender() invoked!!
2021-05-17 23:05:29.796  INFO 32312 --- [           main] com.github.mq.connection.MyMQConnection  : MyMQConnection() invoked!!
2021-05-17 23:05:29.808  INFO 32312 --- [           main] com.github.mq.MyMqSenderApplication      : PostConstruct init() invoked..
2021-05-17 23:05:29.808  INFO 32312 --- [           main] com.github.mq.MyMqSenderApplication      : sending messages...
2021-05-17 23:05:35.556  INFO 32312 --- [           main] com.github.mq.MyMqSenderApplication      : messages sent!!
2021-05-17 23:05:35.769  INFO 32312 --- [           main] com.github.mq.MyMqSenderApplication      : Started MyMqSenderApplication in 7.131 seconds (JVM running for 7.62)
