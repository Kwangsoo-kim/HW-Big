package com.lec.ex4_accessTest;

import com.lec.ex3_accessTest.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.defaultMember); //�ٸ� ��Űġ�� ����Ʈ�� ���Ұ�
		//System.out.println(obj.protectedMember); //�ٸ� ��Ű�� , ��ӹ����͵� �ƴ϶� �ȵ�
		System.out.println(obj.publicMember);
		//obj.defaultMethod();
		//obj.protectedMethod();
		obj.publicMethod();
	}
}
