package com.pal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	@Before("com.pal.aopdemo.aspect.PalAopExpressions.forDaoPackageNoGetterandSetter()")
	public void getApiConfiguration3() {
		System.out.println("\n==> nod getter and setter logging to cloud Async");
	}
}
