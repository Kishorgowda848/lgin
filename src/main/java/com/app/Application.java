package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication /** to say it is spring boot application */
@EnableJpaRepositories(basePackageClasses = UserRepository.class) /**
																	 * To recogranise user repository to create user
																	 * table to store login data
																	 */
 
public class Application {

	public static void main(String[] args) /** main class */
	{
		SpringApplication.run(Application.class, args);
	}

}
