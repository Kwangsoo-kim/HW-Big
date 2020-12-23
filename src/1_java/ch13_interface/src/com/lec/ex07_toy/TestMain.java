package com.lec.ex07_toy;

public class TestMain {
	public static void main(String[] args) {
		Itoy[] t = {new Bear(),
					new Mazinger(),
					new Flight()
		};
		for (Itoy i : t){
			System.out.println(i.getClass().getName());
			System.out.println(i);
			System.out.println("===========================");
		}
	}
}
