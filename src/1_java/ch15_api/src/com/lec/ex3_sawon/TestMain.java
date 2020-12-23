package com.lec.ex3_sawon;

public class TestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "È«±æµ¿", PartType.ACCOUNTING);
		Sawon s2 = new Sawon("a02","»ï±æµ¿",PartType.COMPUTER,2020,12,12);
		System.out.println(s1);
		System.out.println(s2);
	}

}
