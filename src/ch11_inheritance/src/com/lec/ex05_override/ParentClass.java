package com.lec.ex05_override;

public class ParentClass {
	//오버로딩 : 같은 이름의 생성자,매소드 인자타입이 다르면 중복정의 가능.
	//생성자가 2개 :  생성자 함수의 오버로딩overloading(함수의 중복정의)
	//method2가 2개 : 메소드 함수의 오버로딩(매개변수 변환으로 가능)
	public ParentClass() {
		System.out.println("P매개변수 없는 생성자");
	}
	public ParentClass(int i) {
		System.out.println("P매개변수 있는 생성자");
	}
	public void method1() {
		System.out.println("Parent의 method1()");
	}
	public void method2() {
		System.out.println("Parent의 method2()");
	}
	public void method2(int i) {
		
	}
}
