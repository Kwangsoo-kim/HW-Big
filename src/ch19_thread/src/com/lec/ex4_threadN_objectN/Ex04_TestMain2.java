package com.lec.ex4_threadN_objectN;

public class Ex04_TestMain2 {
	public static void main(String[] args) {
		Thread t1 = new Ex03_Thread();
		t1.setName("A");
		Thread t2 = new Ex03_Thread();
		t2.setName("B");
		t1.start();
		t2.start();
	}
}
