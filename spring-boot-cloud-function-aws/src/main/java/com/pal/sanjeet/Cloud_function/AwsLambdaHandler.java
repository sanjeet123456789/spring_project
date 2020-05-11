package com.pal.sanjeet.Cloud_function;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class AwsLambdaHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent,APIGatewayProxyResponseEvent> {

}
