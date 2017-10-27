package com.wyait.ws.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.wyait.ws.domain.GetCountryRequest;
import com.wyait.ws.domain.GetCountryResponse;

public class WsClient extends WebServiceGatewaySupport {
	public GetCountryResponse getCountry(String name) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://127.0.0.1:9111/ws/countries.wsdl",
						request);
		return response;
	}
}