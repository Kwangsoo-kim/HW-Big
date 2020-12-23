package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		Ex04 ex= new Ex04(); //static 없을땐 class에 method를 불러야 한다.
		ex.printCh();
		System.out.println("Hello, World!");
		printCh('=');
		System.out.println("Hello, Java");
		printCh('-', 30);
		
	}
	private static void printCh(char ch, int i) {
		for(int cnt=1;cnt<i+1;cnt++) {  //ch가 i개 있는 라인
			System.out.print(ch);
		}
		System.out.println();
	}
	private static void printCh(char ch) {
		for(int cnt=1;cnt<21;cnt++) { // ch가 20개 있는 라인
			System.out.print(ch);
		}
		System.out.println(); //개행
	}
	//매게 변수가 없는 method
	private void printCh() {
		for(int cnt=1;cnt<21;cnt++) {
			System.out.print('*');
		}
		System.out.println();
	}
}
