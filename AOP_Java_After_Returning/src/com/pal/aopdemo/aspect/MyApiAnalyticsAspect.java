package com.pal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
	@Before("com.pal.aopdemo.aspect.PalAopExpressions.forDaoPackageNoGetterandSetter()")
	public void getApiConfiguration2() {
		System.out.println("\n==> nod getter and setter");
	}
}
