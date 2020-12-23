package com.lec.ex07_toy;

public class Flight implements Imissile,Ilight {
	public Flight() {
		System.out.println(" 비행기 입니다.");
		lit();
		misl();
		System.out.println("=======================");
	}

	@Override
	public void lit() {
		System.out.println("불빛 발사 가능합니다.");
		
	}

	@Override
	public void misl() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}
	@Override
	public String toString() {
		
		return "미사일을 쏠 수 잇고, 불빈반사가 가능한 비행기 ";
	}
}
