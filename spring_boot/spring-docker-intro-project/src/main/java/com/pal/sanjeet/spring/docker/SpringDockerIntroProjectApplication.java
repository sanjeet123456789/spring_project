package com.pal.sanjeet.spring.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("docker/hello")
@SpringBootApplication
public class SpringDockerIntroProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDockerIntroProjectApplication.class, args);
	}
	
	@GetMapping
	public String hello() {
		return "hello world";
	}

/*
	//Dockerfile in spring project
FROM openjdk:8
ADD target/docker-project-hello.jar docker-project-hello.jar
EXPOSE 9693
ENTRYPOINT ["java","-jar","docker-project-hello.jar"]


project-dir $mvn install
any-dir $sudo service docker start
//creating docker image
project-dir $sudo docker build -f Dockerfile -t docker-project-hello .
//check docker images
any-dir $sudo docker images
//run docker image
any-dir $docker run -p 9693:9693 docker-project-hello
*/
}
