package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
//		Super t; //가능은 하나 상속받는 Child의 객체를 만들어야한다. Super의 객체를 만드는 것은 불가능.
//		Super s = new Super() {// 안드로이드개발에선 사용할 순 있다.
//			
//			@Override
//			public void method1() {
//				System.out.println("안드로이드에서만 이런 거 쓴다");
//				
//			}
//		};
//		s.method1();
		Super c1 = new Child();
		c1.method1();
		c1.method2();
		//c1.method3(); 불가능 - Super 타입이라 Super의 것만 가능
		Child c2 = new Child();
		c2.method2();
		c2.method1();
		c2.method3();
	}
}
