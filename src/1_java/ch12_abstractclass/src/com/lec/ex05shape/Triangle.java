package com.lec.ex05shape;

public class Triangle extends Shape {
	private int tw;
	private int th;
	public Triangle() {}
	public Triangle(int tw, int th) {
		this.tw=tw;
		this.th=th;
	}
	@Override
	public double computeArea() {
		return tw*th*0.5;
	}
	@Override
	public void draw() {
		System.out.print("»ï°¢Çü");
		super.draw();
	}
	public int getTw() {
		return tw;
	}
	public void setTw(int tw) {
		this.tw = tw;
	}
	public int getTh() {
		return th;
	}
	public void setTh(int th) {
		this.th = th;
	}

}
