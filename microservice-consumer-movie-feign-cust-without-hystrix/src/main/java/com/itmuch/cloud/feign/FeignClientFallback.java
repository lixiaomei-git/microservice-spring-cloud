package com.itmuch.cloud.feign;

public class FeignClientFallback implements FeignClient2{

	@Override
	public String findServiceInfoFromErueka(String serviceName) {
		// TODO Auto-generated method stub
		return "haha";
	}

}
