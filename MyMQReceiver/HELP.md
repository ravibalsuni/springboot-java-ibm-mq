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

# Import Maven Project in Eclipse, Right Click on Eclipse Project MyMQReceiver, Run As Maven install

# Richt Click MyMqSenderApplication.java, Run As -> Java Application

# sample logs on eclipse console

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.3.10.RELEASE)

2021-05-17 23:23:01.194  INFO 2143 --- [           main] com.github.mq.MyMqReceiverApplication    : Starting MyMqReceiverApplication on ubuntu-pc with PID 2143 (/home/ravi/Desktop/GitHub/MyMQReceiver/target/classes started by ravi in /home/ravi/Desktop/GitHub/MyMQReceiver)
2021-05-17 23:23:01.196  INFO 2143 --- [           main] com.github.mq.MyMqReceiverApplication    : No active profile set, falling back to default profiles: default
2021-05-17 23:23:02.042  INFO 2143 --- [           main] c.g.mq.configuration.MyMQConfiguration   : MyMQConfiguration() invoked..!!
2021-05-17 23:23:02.065  INFO 2143 --- [           main] com.github.mq.listener.MyMQListener      : MyMQReceiver() invoked!!
2021-05-17 23:23:02.099  INFO 2143 --- [           main] c.g.mq.configuration.MyMQConfiguration   : mqConnetionFactory() invoked..!!
2021-05-17 23:23:02.495  INFO 2143 --- [           main] o.m.pooled.jms.JmsPoolConnectionFactory  : Provided ConnectionFactory implementation is JMS 2.0+ capable.
2021-05-17 23:23:02.564  INFO 2143 --- [           main] c.g.mq.configuration.MyMQConfiguration   : destinationResolver() invoked..!!
2021-05-17 23:23:02.568  INFO 2143 --- [           main] c.g.mq.configuration.MyMQConfiguration   : jmsFactory() invoked..!
2021-05-17 23:23:02.738  INFO 2143 --- [           main] com.github.mq.MyMqReceiverApplication    : Started MyMqReceiverApplication in 1.94 seconds (JVM running for 2.41)
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-3] com.github.mq.listener.MyMQListener      : Message 9
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-4] com.github.mq.listener.MyMQListener      : Message 8
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-7] com.github.mq.listener.MyMQListener      : Message 5
2021-05-17 23:23:03.319  INFO 2143 --- [nerContainer-10] com.github.mq.listener.MyMQListener      : Message 1
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-6] com.github.mq.listener.MyMQListener      : Message 7
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 2
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-9] com.github.mq.listener.MyMQListener      : Message 4
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-2] com.github.mq.listener.MyMQListener      : Message 0
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-1] com.github.mq.listener.MyMQListener      : Message 3
2021-05-17 23:23:03.319  INFO 2143 --- [enerContainer-5] com.github.mq.listener.MyMQListener      : Message 6
2021-05-17 23:23:03.372  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 10
2021-05-17 23:23:03.388  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 11
2021-05-17 23:23:03.391  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 12
2021-05-17 23:23:03.422  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 13
2021-05-17 23:23:03.422  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 14
2021-05-17 23:23:03.472  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 22
2021-05-17 23:23:03.472  INFO 2143 --- [enerContainer-6] com.github.mq.listener.MyMQListener      : Message 19
2021-05-17 23:23:03.472  INFO 2143 --- [enerContainer-9] com.github.mq.listener.MyMQListener      : Message 17
2021-05-17 23:23:03.472  INFO 2143 --- [enerContainer-2] com.github.mq.listener.MyMQListener      : Message 16
2021-05-17 23:23:03.473  INFO 2143 --- [enerContainer-4] com.github.mq.listener.MyMQListener      : Message 18
2021-05-17 23:23:03.475  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 24
2021-05-17 23:23:03.476  INFO 2143 --- [enerContainer-7] com.github.mq.listener.MyMQListener      : Message 15
2021-05-17 23:23:03.476  INFO 2143 --- [enerContainer-3] com.github.mq.listener.MyMQListener      : Message 21
2021-05-17 23:23:03.477  INFO 2143 --- [enerContainer-1] com.github.mq.listener.MyMQListener      : Message 20
2021-05-17 23:23:03.478  INFO 2143 --- [enerContainer-5] com.github.mq.listener.MyMQListener      : Message 23
2021-05-17 23:23:03.478  INFO 2143 --- [nerContainer-10] com.github.mq.listener.MyMQListener      : Message 25
2021-05-17 23:23:03.504  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 26
2021-05-17 23:23:03.504  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 27
2021-05-17 23:23:03.538  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 28
2021-05-17 23:23:03.543  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 30
2021-05-17 23:23:03.544  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 29
2021-05-17 23:23:03.589  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 32
2021-05-17 23:23:03.591  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 33
2021-05-17 23:23:03.591  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 31
2021-05-17 23:23:03.629  INFO 2143 --- [enerContainer-4] com.github.mq.listener.MyMQListener      : Message 34
2021-05-17 23:23:03.630  INFO 2143 --- [nerContainer-10] com.github.mq.listener.MyMQListener      : Message 36
2021-05-17 23:23:03.630  INFO 2143 --- [enerContainer-9] com.github.mq.listener.MyMQListener      : Message 37
2021-05-17 23:23:03.629  INFO 2143 --- [enerContainer-2] com.github.mq.listener.MyMQListener      : Message 35
2021-05-17 23:23:03.631  INFO 2143 --- [enerContainer-1] com.github.mq.listener.MyMQListener      : Message 40
2021-05-17 23:23:03.631  INFO 2143 --- [enerContainer-6] com.github.mq.listener.MyMQListener      : Message 38
2021-05-17 23:23:03.632  INFO 2143 --- [enerContainer-7] com.github.mq.listener.MyMQListener      : Message 39
2021-05-17 23:23:03.632  INFO 2143 --- [enerContainer-3] com.github.mq.listener.MyMQListener      : Message 41
2021-05-17 23:23:03.633  INFO 2143 --- [enerContainer-5] com.github.mq.listener.MyMQListener      : Message 42
2021-05-17 23:23:03.654  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 43
2021-05-17 23:23:03.655  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 45
2021-05-17 23:23:03.654  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 44
2021-05-17 23:23:03.705  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 46
2021-05-17 23:23:03.705  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 48
2021-05-17 23:23:03.705  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 47
2021-05-17 23:23:03.763  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 49
2021-05-17 23:23:03.764  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 50
2021-05-17 23:23:03.765  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 51
2021-05-17 23:23:03.769  INFO 2143 --- [nerContainer-13] com.github.mq.listener.MyMQListener      : Message 52
2021-05-17 23:23:03.787  INFO 2143 --- [nerContainer-10] com.github.mq.listener.MyMQListener      : Message 60
2021-05-17 23:23:03.787  INFO 2143 --- [enerContainer-2] com.github.mq.listener.MyMQListener      : Message 53
2021-05-17 23:23:03.788  INFO 2143 --- [enerContainer-9] com.github.mq.listener.MyMQListener      : Message 61
2021-05-17 23:23:03.787  INFO 2143 --- [enerContainer-6] com.github.mq.listener.MyMQListener      : Message 58
2021-05-17 23:23:03.788  INFO 2143 --- [enerContainer-7] com.github.mq.listener.MyMQListener      : Message 55
2021-05-17 23:23:03.788  INFO 2143 --- [enerContainer-5] com.github.mq.listener.MyMQListener      : Message 59
2021-05-17 23:23:03.787  INFO 2143 --- [enerContainer-3] com.github.mq.listener.MyMQListener      : Message 56
2021-05-17 23:23:03.789  INFO 2143 --- [enerContainer-4] com.github.mq.listener.MyMQListener      : Message 57
2021-05-17 23:23:03.788  INFO 2143 --- [enerContainer-1] com.github.mq.listener.MyMQListener      : Message 54
2021-05-17 23:23:03.830  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 62
2021-05-17 23:23:03.830  INFO 2143 --- [nerContainer-13] com.github.mq.listener.MyMQListener      : Message 65
2021-05-17 23:23:03.830  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 63
2021-05-17 23:23:03.830  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 64
2021-05-17 23:23:03.917  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 67
2021-05-17 23:23:03.917  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 69
2021-05-17 23:23:03.917  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 68
2021-05-17 23:23:03.917  INFO 2143 --- [nerContainer-13] com.github.mq.listener.MyMQListener      : Message 66
2021-05-17 23:23:03.920  INFO 2143 --- [enerContainer-4] com.github.mq.listener.MyMQListener      : Message 74
2021-05-17 23:23:03.921  INFO 2143 --- [enerContainer-7] com.github.mq.listener.MyMQListener      : Message 71
2021-05-17 23:23:03.922  INFO 2143 --- [enerContainer-5] com.github.mq.listener.MyMQListener      : Message 73
2021-05-17 23:23:03.923  INFO 2143 --- [enerContainer-6] com.github.mq.listener.MyMQListener      : Message 75
2021-05-17 23:23:03.922  INFO 2143 --- [enerContainer-9] com.github.mq.listener.MyMQListener      : Message 77
2021-05-17 23:23:03.923  INFO 2143 --- [enerContainer-3] com.github.mq.listener.MyMQListener      : Message 72
2021-05-17 23:23:03.923  INFO 2143 --- [enerContainer-2] com.github.mq.listener.MyMQListener      : Message 76
2021-05-17 23:23:03.924  INFO 2143 --- [nerContainer-10] com.github.mq.listener.MyMQListener      : Message 70
2021-05-17 23:23:03.924  INFO 2143 --- [enerContainer-1] com.github.mq.listener.MyMQListener      : Message 78
2021-05-17 23:23:03.988  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 79
2021-05-17 23:23:03.988  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 81
2021-05-17 23:23:03.989  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 80
2021-05-17 23:23:03.989  INFO 2143 --- [nerContainer-13] com.github.mq.listener.MyMQListener      : Message 82
2021-05-17 23:23:04.062  INFO 2143 --- [nerContainer-13] com.github.mq.listener.MyMQListener      : Message 84
2021-05-17 23:23:04.064  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 83
2021-05-17 23:23:04.064  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 86
2021-05-17 23:23:04.064  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 85
2021-05-17 23:23:04.071  INFO 2143 --- [enerContainer-3] com.github.mq.listener.MyMQListener      : Message 88
2021-05-17 23:23:04.072  INFO 2143 --- [enerContainer-2] com.github.mq.listener.MyMQListener      : Message 89
2021-05-17 23:23:04.073  INFO 2143 --- [enerContainer-4] com.github.mq.listener.MyMQListener      : Message 87
2021-05-17 23:23:04.074  INFO 2143 --- [enerContainer-5] com.github.mq.listener.MyMQListener      : Message 91
2021-05-17 23:23:04.075  INFO 2143 --- [enerContainer-6] com.github.mq.listener.MyMQListener      : Message 92
2021-05-17 23:23:04.075  INFO 2143 --- [enerContainer-9] com.github.mq.listener.MyMQListener      : Message 90
2021-05-17 23:23:04.074  INFO 2143 --- [enerContainer-7] com.github.mq.listener.MyMQListener      : Message 93
2021-05-17 23:23:04.075  INFO 2143 --- [nerContainer-10] com.github.mq.listener.MyMQListener      : Message 94
2021-05-17 23:23:04.075  INFO 2143 --- [enerContainer-1] com.github.mq.listener.MyMQListener      : Message 95
2021-05-17 23:23:04.129  INFO 2143 --- [nerContainer-12] com.github.mq.listener.MyMQListener      : Message 98
2021-05-17 23:23:04.145  INFO 2143 --- [nerContainer-11] com.github.mq.listener.MyMQListener      : Message 99
2021-05-17 23:23:04.145  INFO 2143 --- [nerContainer-13] com.github.mq.listener.MyMQListener      : Message 96
2021-05-17 23:23:04.129  INFO 2143 --- [enerContainer-8] com.github.mq.listener.MyMQListener      : Message 97


# terminate the application otherwise it will be running forever :p

kill -9 2143

or

via eclipse
