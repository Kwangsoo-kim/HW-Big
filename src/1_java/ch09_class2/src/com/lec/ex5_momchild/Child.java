package com.lec.ex5_momchild;
// Child child1 = new Child("ù° �ʶ���");
// child1.takeMoney(100);
public class Child {
	private String name;
	static MomPouch momPouch;
	public Child(String name) {
		this.name=name;
		momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money>=money) {
			momPouch.money -= money;
			System.out.println(name+"�� "+money+" �� �������� ����������"+ momPouch.money+"��");
		}else {
			System.out.println(name+"�� ���� ������. ���� ���������� "+momPouch.money+"��");
		}
	}
}
