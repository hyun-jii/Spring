/*==========================================
 	Main.java
 	- 클래스.
 	- main() 메소드가 포함된 테스트 클래스.
============================================ */
package com.test.spr;

import java.lang.reflect.Proxy;

public class Main
{

	public static void main(String[] args)
	{
		// 주 업무를 실행 할 수 있는 객체 준비
		// 『인터페이스 변수 = new 인터페이스구현클래스();』
		Calculator cal = new CalculatorImpl();
		
		// 업무 실행 테스트
		/*
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int multi = cal.multi(10, 20);
		System.out.println(multi);
		
		int div = cal.div(10, 20);
		System.out.println(div);
		*/
		
		Calculator proxy = (Calculator)Proxy.newProxyInstance(
				cal.getClass().getClassLoader()		// 주 업무 실행 클래스에 대한 정보 전달(제공)
				, cal.getClass().getInterfaces() 	// 주 업무 실행 클래스의 인터페이스에 대한 정보 전달(제공)
				, new CalculatorProxy(cal));		// 보조 업무 실행 클래스에 대한 정보 전달(제공)
		
		int add = proxy.add(10, 20);
		System.out.println(add);
		
		int sub = proxy.sub(10, 20);
		System.out.println(sub);
		
		int multi = proxy.multi(10, 20);
		System.out.println(multi);
		
		int div = proxy.div(10, 20);
		System.out.println(div);
	}

}
