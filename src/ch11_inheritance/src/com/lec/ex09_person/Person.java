package com.lec.ex09_person;
// Person p = new Person("홍길동","착하다");
public class Person {
	private String na;
	private String cha;
    public Person() {
		System.out.println("매개변수 없는 p생성자 호출");
	}
	public Person(String na, String cha) {
		System.out.println("매개변수 있는 p생성자 호출");
		this.na=na;
		this.cha=cha;
	}
	public void intro() {
		System.out.println(na+"은(는)"+cha);
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
	public String getCha() {
		return cha;
	}
	public void setCha(String cha) {
		this.cha = cha;
	}
	

}
