package com.lec.ex3_threadN_object1;

public class Ex02_TestMain {
	public static void main(String[] args) {
		Ex01_Thread target = new Ex01_Thread(); //�۾���ü 1�� Thread ����
		Thread t1 = new Thread(target,"A");
		Thread t2 = new Thread(target,"B");
		t1.start();
		t2.start();
		//���������� ���������� B��ü�� num���� ������ ��ó�� ����
		
	}
}
