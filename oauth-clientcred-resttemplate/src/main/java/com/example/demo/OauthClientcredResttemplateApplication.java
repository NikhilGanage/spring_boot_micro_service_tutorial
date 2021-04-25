package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@SpringBootApplication
public class OauthClientcredResttemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OauthClientcredResttemplateApplication.class, args);

		OAuth2RestTemplate template = context.getBean(OAuth2RestTemplate.class);

		String response = template.getForObject("http://localhost:8080/api/v1/customer", String.class);

		System.out.println(response);
	}

	@Bean
	public OAuth2RestTemplate template() {
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();

		resourceDetails.setAccessTokenUri("http://localhost:8080/oauth/token");
		resourceDetails.setClientId("myclient");
		resourceDetails.setClientSecret("pass123");
		resourceDetails.setGrantType("client_credentials");

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
		return restTemplate;
	}

}
