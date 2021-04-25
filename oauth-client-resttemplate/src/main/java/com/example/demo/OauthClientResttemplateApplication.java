package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@SpringBootApplication
public class OauthClientResttemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OauthClientResttemplateApplication.class, args);
		
		OAuth2RestTemplate template = context.getBean(OAuth2RestTemplate.class);
		
		String response = template.getForObject("http://localhost:8585/api/v1/customer", String.class);
		
		System.out.println(response);
	}
	
	@Bean
	public OAuth2RestTemplate template() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		
		resourceDetails.setAccessTokenUri("http://localhost:8585/oauth/token");
		resourceDetails.setClientId("myclient");
		resourceDetails.setClientSecret("pass123");
		resourceDetails.setUsername("india");
		resourceDetails.setPassword("india");
		resourceDetails.setGrantType("password");
		
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
		return restTemplate;
	}

}
