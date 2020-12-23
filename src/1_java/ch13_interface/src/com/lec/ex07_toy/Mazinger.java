package com.lec.ex07_toy;

public class Mazinger implements Imissile, Imovearmleg {
	public Mazinger() {
		System.out.println("마징가 입니다.");
		mal();
		misl();
		System.out.println("=======================");
	}

	@Override
	public void mal() {
		System.out.println("팔 다리를 움직일 수 있습니다.");
	}

	@Override
	public void misl() {
		System.out.println("미사일을 쏠 수 있습니다.");

	}
	@Override
	public String toString() {
		
		return "팔다리가 움직이고 미사일을 쏠 수 있는 마징가 토이 ";
	}

}
