package com.lec.ex09_person;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("¾Æºü°õ","¶×¶×ÇØ");
		Person mom =new Person("¾ö¸¶°õ","³¯¾ÀÇØ");
		papa.intro();
		mom.intro();
		System.out.println("==========================================");
		Baby b1 = new Baby();
		b1.setNa("¾Æ±â°õ1");
		b1.setCha("¹¹ Á» ±Í¿©¾î¤·¤·¤·¤·¤·¤·¤·¤·");
		b1.intro();
		Baby b2 = new Baby("¾Æ±â°õ2","±Í¿©¿ö");
		b2.Cry();
	}
}
