package com.lec.ex07tax;

public class HighGradeCar extends Car{
	private int tax=200000;
	public HighGradeCar(String cl, String tr, int dp, String hd) {
		super(cl, tr, dp, hd);
	}
	@Override
	public void getSpec() {
		System.out.println("======================================");
		System.out.println("���� : "+getCl());
		System.out.println("Ÿ�̾� : "+getTr());
		System.out.println("��ⷮ : "+getDp()+"cc");
		System.out.println("�ڵ� : "+getHd());
		if(getDp()>1500) {
			tax+=(getDp()-1500)*200;
		}
		System.out.println("���� : "+tax+"��");
		System.out.println("**************************************");
	}

	
	
	
}
