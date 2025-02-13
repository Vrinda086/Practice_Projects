package ex.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Example1Application {

	public static void main(String[] args)
	{
		SpringApplication.run(Example1Application.class, args);
	}

}
