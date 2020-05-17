package com.pal.sanjeet.spring.loadbalance.round.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonConfiguration {
	
	@Autowired
	IClientConfig ribbonClint;
	
	@Bean
	public IPing ping(IClientConfig ribbonClint) {
		return new PingUrl();
		
	}
	
	@Bean
	public IRule rule(IClientConfig ribbonClient) {
		return new AvailabilityFilteringRule();
	}
}
