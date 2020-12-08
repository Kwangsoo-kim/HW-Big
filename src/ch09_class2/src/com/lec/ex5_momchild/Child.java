package com.lec.ex5_momchild;
// Child child1 = new Child("첫째 똘똘이");
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
			System.out.println(name+"가 "+money+" 원 가져가서 엄마지갑엔"+ momPouch.money+"원");
		}else {
			System.out.println(name+"가 돈을 못받음. 현재 엄마지갑엔 "+momPouch.money+"원");
		}
	}
}
