package com.lec.ex02_super;

public class Child extends SuperIJ{
	private int total;
	public Child(int i, int j) {
		setI(i);
		setJ(j);
	}
	public void sum(){//total에 i+j할당
		total = getI()+getJ();
		System.out.println("본 객체의 total값  : "+ total);
	}
}
