package com.lec.ex09_person;
// Person p = new Person("ȫ�浿","���ϴ�");
public class Person {
	private String na;
	private String cha;
    public Person() {
		System.out.println("�Ű����� ���� p������ ȣ��");
	}
	public Person(String na, String cha) {
		System.out.println("�Ű����� �ִ� p������ ȣ��");
		this.na=na;
		this.cha=cha;
	}
	public void intro() {
		System.out.println(na+"��(��)"+cha);
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
