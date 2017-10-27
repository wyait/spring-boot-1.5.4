package com.wyait.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyait.ws.client.WsClient;
import com.wyait.ws.domain.GetCountryResponse;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private WsClient wsClient;
    @RequestMapping("callws")
    @ResponseBody
    public Object callWs() {
    	System.out.println("============================");
        GetCountryResponse response = wsClient.getCountry("hello");
        System.out.println("============================");
        return response.getCountry();
    }
    
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
    	System.out.println("============world================");
    	System.out.println("============world================");
    	return "hello world";
    }
}