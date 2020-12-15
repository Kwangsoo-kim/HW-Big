//20.12.15 kks example2
package com.lec.ex08_rectangle;

public class Rectanle {
	private int x;
	private int y;
	private String c;
	public Rectanle() {
		x=0;
		y=0;
		c="검정";
	}
	public Rectanle(int x, int y, String c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Rectanle) {
			return (x==((Rectanle)obj).x && y==((Rectanle)obj).y && c.equals(((Rectanle)obj).c));
		}else {
			return false;
		}
		
	}
	@Override
	public String toString() {
		return "[가로 "+x+"cm, "+"세로 "+y+"cm의 "+c+"색 사각형]";
	}
}
