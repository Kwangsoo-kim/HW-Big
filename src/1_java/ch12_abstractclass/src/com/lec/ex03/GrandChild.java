package com.lec.ex03;

public class GrandChild extends ChildClass{
//ChildClass - 추상 method1(), method2(),method3()
	@Override
	public void method1() {
		System.out.println("GrandChild의 method1()");
	}
	public void method4() {
		System.out.println("GrandChild의 method4()");
	}

}
