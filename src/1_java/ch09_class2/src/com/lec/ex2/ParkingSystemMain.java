package com.lec.ex2;

public class ParkingSystemMain {
	public static void main(String[] args) {
		ParkingSystem car1= new ParkingSystem("11¶ó1111",12);
		ParkingSystem car2 = new ParkingSystem("22·ç2222", 12);
		car1.setOt(14);
		car2.setOt(18);
		car1.outPs();
		car2.outPs();
	}
}
