package com.lec.ex09_person;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("焼匙印","琴琴背");
		Person mom =new Person("畳原印","劾樟背");
		papa.intro();
		mom.intro();
		System.out.println("==========================================");
		Baby b1 = new Baby();
		b1.setNa("焼奄印1");
		b1.setCha("更 岨 瑛食嬢しししししししし");
		b1.intro();
		Baby b2 = new Baby("焼奄印2","瑛食趨");
		b2.Cry();
	}
}
