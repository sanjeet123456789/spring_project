package com.pal.sanjeet.spring.multithreading;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class Configure {
	
	@Bean(name="taskexecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor threadpooltaskexecutor=new ThreadPoolTaskExecutor();
		threadpooltaskexecutor.setCorePoolSize(2);
		threadpooltaskexecutor.setMaxPoolSize(2);
		threadpooltaskexecutor.setQueueCapacity(100);
		threadpooltaskexecutor.setThreadNamePrefix("user thread executor");
		threadpooltaskexecutor.initialize();
		return threadpooltaskexecutor;
	}
	
	
	
}
