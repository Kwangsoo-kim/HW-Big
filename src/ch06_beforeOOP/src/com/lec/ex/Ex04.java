package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		Ex04 ex= new Ex04(); //static ������ class�� method�� �ҷ��� �Ѵ�.
		ex.printCh();
		System.out.println("Hello, World!");
		printCh('=');
		System.out.println("Hello, Java");
		printCh('-', 30);
		
	}
	private static void printCh(char ch, int i) {
		for(int cnt=1;cnt<i+1;cnt++) {  //ch�� i�� �ִ� ����
			System.out.print(ch);
		}
		System.out.println();
	}
	private static void printCh(char ch) {
		for(int cnt=1;cnt<21;cnt++) { // ch�� 20�� �ִ� ����
			System.out.print(ch);
		}
		System.out.println(); //����
	}
	//�Ű� ������ ���� method
	private void printCh() {
		for(int cnt=1;cnt<21;cnt++) {
			System.out.print('*');
		}
		System.out.println();
	}
}
