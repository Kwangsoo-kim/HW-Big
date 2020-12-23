package com.lec.ex01;

public class TestMain {
	public static void main(String[] args) {
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();  //obj2.method2 불가 상속과 같다고 보면된다.
		InterfaceEx2 obj3 = new InterfaceClass();
		obj3.method2();  //obj3.method1 불가 상속과 같다고 보면된다.
	}
}
