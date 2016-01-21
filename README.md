# HiveClient
Remote Java client to access Hive UDF 

Steps to run the HiveClient.java on remote machine.

    1- Copy this java file into eclipse and edit the package structure as you required.
    2- Add following jars into class path
          	commons-logging-1.1.3.jar
	        hive-jdbc-0.13.1.2.1.15.0-946.jar
        	hive-service-0.13.1.2.1.15.0-946.jar
        	libfb303-0.9.0.jar
        	libthrift-0.9.0.jar
        	log4j-1.2.16.jar
        	slf4j-api-1.6.1.jar
        	slf4j-log4j12-1.6.1.jar
        	httpclient-4.2.5.jar
        	httpcore-4.2.5.jar
        	hadoop-common-2.4.0.2.1.15.0-946.jar
        	hive-exec-0.13.1.2.1.15.0-946.jar
        	
    3- Edit HiveClient.java, As per given comment.
    4- Run Java file
    5 - Note that "create function" query will be run only once, when you are registering a new alias.
