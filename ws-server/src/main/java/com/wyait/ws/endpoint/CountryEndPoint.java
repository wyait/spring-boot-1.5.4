package com.wyait.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wyait.ws.domain.Country;
import com.wyait.ws.domain.Currency;
import com.wyait.ws.domain.GetCountryRequest;
import com.wyait.ws.domain.GetCountryResponse;
/**
 * 
 * @项目名称：ws-server
 * @类名称：CountryEndPoint
 * @类描述：编写endpoint
 * @创建人：wyait
 * @创建时间：2017年7月14日 上午11:02:49 
 * @version：
 */
@Endpoint
public class CountryEndPoint {

	private static final String NAMESPACE_URI = "http://www.wyait.com/ws";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(
			@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		Country poland = new Country();
		poland.setName("Poland-" + request.getName());
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);
		response.setCountry(poland);
		return response;
	}
}
