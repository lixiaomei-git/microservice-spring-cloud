package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserReporsitory;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@Autowired
	private UserReporsitory userRepository;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER-EUREKA", false);
		return instance.getHomePageUrl();
	}
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInfo = this.discoveryClient.getLocalServiceInstance();
		return localServiceInfo;
	}
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
	
	@PostMapping("/test")
	public User postUser(@RequestBody User user) {
		return user;
	}
}
