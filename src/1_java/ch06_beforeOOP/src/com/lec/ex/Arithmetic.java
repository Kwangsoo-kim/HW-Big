package com.lec.ex;

public class Arithmetic {
	public int sumhod(int from, int to) {
		int result = 0; // 누적할 변수
		for (int i = from; i < to + 1; i++) {
			result += i;
		}
		return result;
	}

	// method의 다용성, 같은 변수명으로 다른 method 만들 수 있다.
	public int sumhod(int to) {
		int result = 0;
		for (int i = 1; i < to + 1; i++) {
			result += i;
		}
		return result;
	}

	// evenOdd() method
	public String evenOdd(int value) {
		String result = (value % 2 == 0) ? "짝수입니다" : "홀수입니다.";
		return result;
	}
	// 절대값 뽑는 method
	public static int abs(int value) {
		int result = (value>=0)? value : -value;
//		if(value>=0) {
//			result = value;
//		}else {
//			result = -value;
//		}
		return result;
	}
}
