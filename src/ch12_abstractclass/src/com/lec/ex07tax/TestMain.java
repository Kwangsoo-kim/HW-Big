package com.lec.ex07tax;

import com.lec.cons.CarSpecTable;

public class TestMain {
	public static void main(String[] args) {
		Car lC =new LowGradeCar(CarSpecTable.GRAY_COLOR, CarSpecTable.TIRE_NOMAL,CarSpecTable.DISPLACEMENT_1000,CarSpecTable.HANDLE_POWER);
		Car hC = new HighGradeCar(CarSpecTable.RED_COLOR,CarSpecTable.TIRE_WIDE,CarSpecTable.DISPLACEMENT_2000,CarSpecTable.HANDLE_POWER);
		lC.getSpec();
		hC.getSpec();
	}
}
