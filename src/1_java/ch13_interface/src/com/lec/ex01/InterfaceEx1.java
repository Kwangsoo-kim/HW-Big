package com.lec.ex01;
//interface에는 항상 상수와 추상메소드만 올 수 있다.
//interface는 두개이상 implement 받을 수 있다.
public interface InterfaceEx1 {
	public /* static final */ int CONSTANT_NUM = 10; //interface에서는 static final 생략 가능.
	public abstract void method1(); //interface에서는 abstract 생략 가능.
}
