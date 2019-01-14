package com.sillycat.springcloud.consulconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallHelloController {

	@Autowired
	private LoadBalancerClient loadBalancer;

	@RequestMapping("/hello")
	public String call() {
		ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
		System.out.println("Service URL:" + serviceInstance.getUri());
		System.out.println("Service Name:" + serviceInstance.getServiceId());
		String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello",
				String.class);
		System.out.println(callServiceResult);
		return callServiceResult;
	}

}
