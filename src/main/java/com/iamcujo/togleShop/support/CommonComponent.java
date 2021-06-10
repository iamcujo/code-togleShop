package com.iamcujo.togleShop.support;

import org.springframework.stereotype.Component;

@Component
public class CommonComponent {
	protected static String sClassName;
	protected static String sMethodName;
	protected static String sLogPosition;
	
	public CommonComponent() throws Exception {
	}
	
	/**
	 * @author iamcujo
	 * @desc   호출된 클래스 및 메소드 확인 
	 */
	public static String getCallPosition() {
		//sClassName   = this.getClass().getName();
		//sMethodName  = new Object(){}.getClass().getEnclosingMethod().getName();
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[ 1 ];
		sClassName   = beforeStack.getClassName();
		sMethodName  = beforeStack.getMethodName();
		sLogPosition = "[Class : "+sClassName+", Method : "+sMethodName+"] ";
		
		return sLogPosition;
	}
	/**
	 * @author iamcujo
	 * @desc   호출된 클래스 및 메소드 확인(log4j 로그용) 
	 */
	public static String getCallPositionForCommonComponent() {
		//sClassName   = this.getClass().getName();
		//sMethodName  = new Object(){}.getClass().getEnclosingMethod().getName();
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[ 2 ];
		sClassName   = beforeStack.getClassName();
		sMethodName  = beforeStack.getMethodName();
		sLogPosition = "[Class : "+sClassName+", Method : "+sMethodName+"] ";
		
		return sLogPosition;
	}
}
