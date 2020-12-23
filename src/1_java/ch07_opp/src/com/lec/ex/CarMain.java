package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myP = new Car();
		Car youP = new Car();
		myP.drive();
		youP.drive();
		myP.park();
		myP.race();
		myP.setColor("red");; //myP.color = "red";
		youP.setColor("black");
		myP.setCc(1500);
		System.out.println("³» Æ÷¸£½¦ »ö»ó : "+myP.getColor());
		System.out.println("´Ï Æ÷¸£½¦ »ö»ó : "+youP.getColor());
		System.out.println("³» Æ÷¸£½¦ cc : "+myP.getCc());
		System.out.println("´Ï Æ÷¸£½¦ cc : "+youP.getCc());
		
		
	}
}
