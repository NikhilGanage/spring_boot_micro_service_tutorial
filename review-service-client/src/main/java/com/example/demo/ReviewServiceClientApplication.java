package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReviewServiceClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(ReviewServiceClientApplication.class, args);
		
		RestTemplate restTemplate = context.getBean(RestTemplate.class);
		
		String response = restTemplate.getForObject("http://REVIEW-SERVICE/api/v1/reviews", String.class);
		
		System.out.println(response);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate template(BasicAuthenticationInterceptor interceptor) {
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(interceptor);
		return template;
	}
	
	@Bean
	public BasicAuthenticationInterceptor interceptor() {
		return new BasicAuthenticationInterceptor("india", "india");
	}

}
