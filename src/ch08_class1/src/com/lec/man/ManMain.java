package com.lec.man;

public class ManMain {
	public static void main(String[] args) {
		Man kim = new Man(40,170,30,"010-4949-9494");
		Man yi = new Man(20,170,69);
		Man park = new Man(30,"101-1101-1010");
		Man[] st = {kim,yi,park};
		yi.setPn("333-3333-3333");
		park.setH(180);
		park.setW(70);
		double biman = kim.cB();
		if(biman>24) {
			System.out.println("kim은 비만이니 건강조심");
		}else {
			System.out.println("kim은 다이어트 금지");
		}
		biman = yi.cB();
		System.out.println(biman>24 ? "건강조심, 다이어트 ": "다이어트 금지");
		biman = park.cB();
		System.out.println(biman>24 ? "건강조심, 다이어트 ": "다이어트 금지");
	}
}
