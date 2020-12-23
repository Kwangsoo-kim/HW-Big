package com.lec.ex05shape;

public class Rectangle extends Shape {
	private int w;
	private int h;
	public Rectangle() {}
	public Rectangle(int w, int h) {
		this.w=w;
		this.h=h;
	}
	@Override
	public double computeArea() {
		return w*h;
	}
	@Override
	public void draw() {
		System.out.print("���簢��");
		super.draw();
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}

}
