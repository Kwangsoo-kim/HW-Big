package com.lec.ex02;
// 추상클래스는 한개이상의 추상메소드를 갖는다.
// Super s = new Super();  불가능
// s.method1(); 불가능
public abstract class Super {
	public Super() {} //디폴트 생성자
	public abstract void method1(); //추상메소드
	public void method2() {
		System.out.println("Super의 method2()");
	}
}
