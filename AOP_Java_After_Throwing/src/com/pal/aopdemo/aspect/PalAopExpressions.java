package com.pal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;




//shift+ctrl+o to auto import
@Aspect

public class PalAopExpressions {
	@Pointcut("execution(* com.pal.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create a pointcut for getter methods
	@Pointcut("execution(* com.pal.aopdemo.dao.*.get*(..))")
	public void getter() {}
	// create a point cut for setter methods
	@Pointcut("execution(* com.pal.aopdemo.dao.*.set*(..))")
	public void setter() {}
	//create point include package ..exclude gettter/setter
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	public void forDaoPackageNoGetterandSetter() {}
	
	
}
