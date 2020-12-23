package com.lec.ex07tax;

public class HighGradeCar extends Car{
	private int tax=200000;
	public HighGradeCar(String cl, String tr, int dp, String hd) {
		super(cl, tr, dp, hd);
	}
	@Override
	public void getSpec() {
		System.out.println("======================================");
		System.out.println("색상 : "+getCl());
		System.out.println("타이어 : "+getTr());
		System.out.println("배기량 : "+getDp()+"cc");
		System.out.println("핸들 : "+getHd());
		if(getDp()>1500) {
			tax+=(getDp()-1500)*200;
		}
		System.out.println("세금 : "+tax+"원");
		System.out.println("**************************************");
	}

	
	
	
}
