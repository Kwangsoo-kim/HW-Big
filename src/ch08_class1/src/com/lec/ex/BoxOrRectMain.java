package com.lec.ex;

public class BoxOrRectMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		box.calNestVolume();
		rect.calNestVolume();
		System.out.println("�ڽ� ���� : " + box.getV());
		System.out.println("rect ���� : "+ rect.getV());
		
	
	}
}
