package com.pal.sanjeet.spring.Cloud_function;

import java.util.function.Function;


public class Hello implements Function<String,String> {

	@Override
	public String apply(String t) {
		// TODO Auto-generated method stub
		return "Hello"+t;
	}

}
