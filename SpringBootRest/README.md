SpringBoot - REST application 

This sample application has two Controllers. 
	- HelloController - annoted wiith 'profile=prod'
	- PingController

To run the application on 'prod' profile, set a system property on the server as follows:
	STS --> Run --> Run Configurations --> Arguments --> VM arguments
		-Dspring.profiles.active=test

To access the REST endpoints:
	1) http://localhost:8090/hello
	2) http://localhost:8090/ping

