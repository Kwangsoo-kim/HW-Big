package com.lec.ex03;

public class TestMain {
	public static void main(String[] args) {
//		SuperClass s = new SuperClass();
//		ChildClass c = new ChildClass();              둘다 불가능, 추상메소드를 가지고있다.
		GrandChild g1 = new GrandChild();
		ChildClass g2 = new GrandChild();
		SuperClass g3 = new GrandChild();
		g1.method1();
		g1.method2();
		g1.method3();
		g1.method4();
		g2.method1();
		g2.method2();
		g2.method3();
		g3.method1();
		g3.method2();
		
	}
}
