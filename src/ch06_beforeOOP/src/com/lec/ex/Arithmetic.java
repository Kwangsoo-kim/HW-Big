package com.lec.ex;

public class Arithmetic {
	public int sumhod(int from, int to) {
		int result = 0; // ������ ����
		for (int i = from; i < to + 1; i++) {
			result += i;
		}
		return result;
	}

	// method�� �ٿ뼺, ���� ���������� �ٸ� method ���� �� �ִ�.
	public int sumhod(int to) {
		int result = 0;
		for (int i = 1; i < to + 1; i++) {
			result += i;
		}
		return result;
	}

	// evenOdd() method
	public String evenOdd(int value) {
		String result = (value % 2 == 0) ? "¦���Դϴ�" : "Ȧ���Դϴ�.";
		return result;
	}
	// ���밪 �̴� method
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
