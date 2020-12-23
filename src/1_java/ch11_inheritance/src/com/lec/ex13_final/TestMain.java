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
		//d2.method(); 불가능.
		Object d3 = new Dog(); //여기까지느 가능하나 Object 함수 제외 사용 불가능하다.
		d2.running();
		Rabbit ra= new Rabbit();
		ra.running();
		ra.stop();
		
	}
}
