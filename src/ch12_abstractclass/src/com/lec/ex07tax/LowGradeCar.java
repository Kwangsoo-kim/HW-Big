package com.lec.ex07tax;

public class LowGradeCar extends Car{
	private int tax=50000;
	public LowGradeCar(String cl, String tr, int dp, String hd) {
		super(cl, tr, dp, hd);
	}

	

	@Override
	public void getSpec() {//spec�� ���(tax����)
		System.out.println("======================================");
		System.out.println("���� : "+getCl());
		System.out.println("Ÿ�̾� : "+getTr());
		System.out.println("��ⷮ : "+getDp()+"cc");
		System.out.println("�ڵ� : "+getHd());
		if(getDp()>1000) {
			tax+=(getDp()-1000)*100;
		}
		System.out.println("���� : "+tax+"��");
		System.out.println("**************************************");
	}
}
