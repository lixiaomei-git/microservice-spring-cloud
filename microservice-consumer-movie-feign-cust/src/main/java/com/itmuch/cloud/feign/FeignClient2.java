package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.config.Configuration2;


@FeignClient(name="microservice-provider-user-eureka",configuration=Configuration2.class)
public interface FeignClient2 {
	
	@RequestMapping(value="/eureka/apps/{serviceName}",method=RequestMethod.GET)
	public String findServiceInfoFromErueka(@PathVariable("serviceName") String serviceName);
}
