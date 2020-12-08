package com.lec.ex;

public class BoxOrRect {
	private int w;
	private int h;
	private int d;
	private int v;
	
	public BoxOrRect() {}
	public BoxOrRect(int w, int h, int d) {
		this.w=w;
		this.h=h;
		this.d=d;
	}
	public BoxOrRect(int w, int h) {
		this.w=w;
		this.h=h;
	}
	
	public int calNestVolume() {
	int volume =( d != 0? w*h*d : w*h);
	this.v=volume;
	return v;
	}
	public void setW(int w) {
		this.w=w;
	}
	public void setH(int h) {
		this.h=h;
	}
	public void setD(int d) {
		this.d=d;
	}
	public void setV(int v) {
		this.v=v;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int getD() {
		return d;
	}
	public int getV() {
		return v;
	}
}
