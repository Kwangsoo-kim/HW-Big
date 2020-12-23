package com.lec.ex05shape;

public class Circle extends Shape {
	private int r;
	public Circle() {}
	public Circle(int r) {
		this.r=r;
	}
	@Override
	public double computeArea() {
		return 3.14*r*r;
		
	}
	@Override
	public void draw() {
		System.out.print("¿ø");
		super.draw();
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
}
