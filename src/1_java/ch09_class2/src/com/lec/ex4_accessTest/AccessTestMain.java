package com.lec.ex4_accessTest;

import com.lec.ex3_accessTest.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.defaultMember); //다른 패키치라 디폴트는 사용불가
		//System.out.println(obj.protectedMember); //다른 패키지 , 상속받은것도 아니라 안됨
		System.out.println(obj.publicMember);
		//obj.defaultMethod();
		//obj.protectedMethod();
		obj.publicMethod();
	}
}
