package com.lec.ex3_accessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember);  
		System.out.println(obj.defaultMember);   //���� ��Ű���� ����
		System.out.println(obj.protectedMember);  //���� ��Ű���� ����
		System.out.println(obj.publicMember);
		//obj.privateMethod();
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	
	}
}