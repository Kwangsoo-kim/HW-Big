package com.lec.ex02_super;

public class SuperIJ {
	private int i;
	private int j;
	public SuperIJ() { //부모클래스는 상속할때 매개변수없는 생성자가 필요하다. 없다면 다른 조취가 필요.
		System.out.println("매개변수 없는 거");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는거");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
