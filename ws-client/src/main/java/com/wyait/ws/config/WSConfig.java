package com.wyait.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.wyait.ws.client.WsClient;

@Configuration
public class WSConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.wyait.ws.domain");
		return marshaller;
	}

	@Bean
	public WsClient wsClient(Jaxb2Marshaller marshaller) {
		WsClient client = new WsClient();
		client.setDefaultUri("http://127.0.0.1:9111/ws/countries.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}