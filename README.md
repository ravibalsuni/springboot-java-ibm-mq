# Springboot Java IBM MQ 9.2.2.0 repo  (This demo was implemented on ubuntu 18.04)

This includes:
		1) IBM MQ 9.2.2.0 Installation

		2) MyMQSender Springboot Application 

		3) MyMQReceiver Springboot Application (which listens MQ msgs forever) 


#Step 1 - Installing IBM MQ 9.2.2.0

	1.1) download binaries - 'mqadv_dev922_ubuntu_x86-64.tar.gz' from - https://ibm.biz/mq-advanced-ubuntu

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


