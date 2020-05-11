package com.pal.sanjeet.Cloud_function;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Component
public class Hello_world implements Function<APIGatewayProxyRequestEvent,APIGatewayProxyResponseEvent> {

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent t) {
		APIGatewayProxyResponseEvent responseEvent=new APIGatewayProxyResponseEvent();
		responseEvent.setStatusCode(200);
		responseEvent.setBody("hello sanjeet"+t);
		return responseEvent;
	}
	
	
	
	
}	
