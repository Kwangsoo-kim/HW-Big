package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();
		S a = new A();//  =  A a = new A();
	//Object a1 = new A();
	//System.out.println(a1.s);   //¿À·ù³².
		System.out.println(a.s);
		S b = new B();
		S c = new C();
		S[] sArr= { new A(),
					new B(),
					new C()
		};
		}
}

