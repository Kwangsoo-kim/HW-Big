package com.lec.ex;
//method 
public class Ex02 {
	public static void main(String[] args) {
		int sum = sumhod(1,10);
		System.out.println("합은 : " + sum);
		System.out.println(evenOdd(sum));
		sum = sumhod(100);
		System.out.println("합은 : " + sum);
		System.out.println(evenOdd(sum));
		sum = sumhod(10,51);
		System.out.println("합은 : " + sum);
		System.out.println(evenOdd(sum));
	}
	// sumhod() method
	private static int sumhod(int from, int to) {
		int result = 0; //누적할 변수
		for(int i=from; i<to+1;i++) {
			result +=i;
		}
		return result;
	}
	//method의 다용성, 같은 변수명으로 다른 method 만들 수 있다.
	private static int sumhod(int to) {
		int result =0;
		for(int i=1; i<to+1; i++) {
			result +=i;
		}
		return result;
	}
	// evenOdd() method
	private static String evenOdd(int value) {
		String result = (value%2==0)? "짝수입니다":"홀수입니다.";
		return result;
	}
}
