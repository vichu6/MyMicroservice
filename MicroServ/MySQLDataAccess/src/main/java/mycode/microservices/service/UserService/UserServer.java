package mycode.microservices.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import mycode.data.user.UserController;
import mycode.data.user.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(UserController.class)
public class UserServer {

	@Autowired
	private UserRepository user;
	
	public static void main(String[] args) {
		
		
		System.setProperty("spring.config.name", "users-server");
		SpringApplication.run(UserServer.class, args);

	}

}
