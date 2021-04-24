package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomPreFilter extends AbstractGatewayFilterFactory<CustomPreFilter.Config> {

	public static class Config {
		
	}
	
	
	
	public CustomPreFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}



	@Override
	public GatewayFilter apply(Config config) {
		
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();

//			URI requestUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);

			System.out.println("PRE FILTER =:" + request);
//			System.out.println("PRE Filter =:" + requestUrl);

			return chain.filter(exchange.mutate().build());

		};
	}

}
