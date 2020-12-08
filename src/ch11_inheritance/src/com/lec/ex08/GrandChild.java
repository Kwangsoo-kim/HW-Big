package com.lec.ex08;

public class GrandChild extends Child1 {
	private int gc = 3;
	public GrandChild() {
		System.out.println("gc형 객체 생성");
	}
	public int getG() {
		return gc;
	}
	public void setG(int gc) {
		this.gc = gc;
	}

}
