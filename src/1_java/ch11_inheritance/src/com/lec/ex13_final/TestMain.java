package com.lec.ex13_final;

public class TestMain {
	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.running();
		ani.running();
		ani.stop();
		Dog d1 = new Dog();
		d1.running();
		d1.method();
		Animal d2 = new Dog();
		//d2.method(); �Ұ���.
		Object d3 = new Dog(); //��������� �����ϳ� Object �Լ� ���� ��� �Ұ����ϴ�.
		d2.running();
		Rabbit ra= new Rabbit();
		ra.running();
		ra.stop();
		
	}
}
