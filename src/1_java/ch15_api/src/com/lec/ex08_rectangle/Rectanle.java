//20.12.15 kks example2
package com.lec.ex08_rectangle;

public class Rectanle {
	private int x;
	private int y;
	private String c;
	public Rectanle() {
		x=0;
		y=0;
		c="����";
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
		return "[���� "+x+"cm, "+"���� "+y+"cm�� "+c+"�� �簢��]";
	}
}
