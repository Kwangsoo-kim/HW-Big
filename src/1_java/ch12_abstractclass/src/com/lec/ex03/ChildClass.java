package com.lec.ex03;

public abstract class ChildClass extends SuperClass{ 
	// Super클래스로부터 받은 추상 메소드 method1()이 있기 때문에,
	// 오버라이드를 하던지 자기가 추상클래스가 되든지 하면 된다.
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2()");
		
	}
	public void method3() {
		System.out.println("ChildClass의 method3()");
	}
}
