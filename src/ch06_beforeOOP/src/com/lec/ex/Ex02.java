package com.lec.ex;
//method 
public class Ex02 {
	public static void main(String[] args) {
		int sum = sumhod(1,10);
		System.out.println("���� : " + sum);
		System.out.println(evenOdd(sum));
		sum = sumhod(100);
		System.out.println("���� : " + sum);
		System.out.println(evenOdd(sum));
		sum = sumhod(10,51);
		System.out.println("���� : " + sum);
		System.out.println(evenOdd(sum));
	}
	// sumhod() method
	private static int sumhod(int from, int to) {
		int result = 0; //������ ����
		for(int i=from; i<to+1;i++) {
			result +=i;
		}
		return result;
	}
	//method�� �ٿ뼺, ���� ���������� �ٸ� method ���� �� �ִ�.
	private static int sumhod(int to) {
		int result =0;
		for(int i=1; i<to+1; i++) {
			result +=i;
		}
		return result;
	}
	// evenOdd() method
	private static String evenOdd(int value) {
		String result = (value%2==0)? "¦���Դϴ�":"Ȧ���Դϴ�.";
		return result;
	}
}
