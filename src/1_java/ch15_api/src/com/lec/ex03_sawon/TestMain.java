package com.lec.ex03_sawon;

public class TestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "ȫ�浿", PartType.ACCOUNTING);
		Sawon s2 = new Sawon("a02","��浿",PartType.COMPUTER,2020,12,12);
		System.out.println(s1);
		System.out.println(s2);
	}

}
