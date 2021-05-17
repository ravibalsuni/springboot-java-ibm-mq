# Springboot Java IBM MQ 9.2.2.0 repo  
(This demo was implemented on ubuntu 18.04)

It includes:

		1) IBM MQ 9.2.2.0 Installation

		2) MyMQSender Springboot Application 

		3) MyMQReceiver Springboot Application (which listens MQ msgs forever) 


# Step 1  

	Installing IBM MQ 9.2.2.0

	1.1) download binaries - 'mqadv_dev922_ubuntu_x86-64.tar.gz' from:
		 https://ibm.biz/mq-advanced-ubuntu	or
		 https://drive.google.com/file/d/13eihJyeaHWRcr84OxJbMem3xTFc8ZCb2/view

	1.2) Unzip the folder you downloaded. The contents extract to a folder named “MQServer”. 
             e.g. /home/ravi/Downloads/MQServer

	1.3) run following commands on ubuntu terminal for creating a user and group for running MQ client applications.
	   (user 'app' will be used in our Java application for sending and receiving mq messages. 
            Remember the password while creating user)

		sudo addgroup mqclient
		sudo adduser app
		sudo adduser app mqclient
		go to the MQServer directory crated at 1.2) e.g. cd /home/ravi/Downloads/MQServer
		sudo ./mqlicense.sh -text_only

	1.4) Go to the directory /etc/apt/sources.list.d
    	     Create a .list file with a name - ibmmq-install.list
	     add the following 1 line in theibmmq-install.list file:
		deb [trusted=yes] file:/home/username/Downloads/MQServer .

	1.5) run following commands on ubuntu terminal
		sudo apt update
		sudo apt install "ibmmq-*"

	1.6) check the installation by running following command on ubuntu terminal
		/opt/mqm/bin/dspmqver
	     output - should display version of MQ installed i.e. 9.2.2.0

	1.7) setting MQ env for development by running following command on ubuntu terminal
		sudo adduser $(whoami) mqm
		cd /opt/mqm/bin
		. setmqenv -s

	1.8) creating and starting queue manager (this will be used in our java code for connecion)
		crtmqm QM1
		strmqm QM1

	1.9) create a directory anywhere within your system, e.g. mkdir /home/ravi/Downloads/mqscript-web
	     then create a new file named: 	"mq-config.mqsc"
	     This is the script file which we will run to create mq objects and use them in our java code.
	     File url - https://github.com/ravibalsuni/springboot-java-ibm-mq/blob/master/mq-config.mqsc
	     
       1.10) run this file using following command:
	     cd /home/ravi/Downloads/mqscript-web
	     runmqsc QM1 < "./mq-config.mqsc"

       1.11) run these commands to give authority to mqclient group
	      setmqaut -m QM1 -t qmgr -g mqclient +connect +inq
	      setmqaut -m QM1 -n DEV.** -t queue -g mqclient +put +get +browse +inq



# Step 2
	
	Refer MyMQSender Springboot Project to send few messages on queue created via above command at 1.10)
	We use following local queue - "DEV.QUEUE.1" to send messages
	  

# Step 3  

	Refer MyMQReceiver Springboot Project to receive/listen those messages from same queue
	We use same local queue - "DEV.QUEUE.1" to listen messages from, which will sent at step 2


