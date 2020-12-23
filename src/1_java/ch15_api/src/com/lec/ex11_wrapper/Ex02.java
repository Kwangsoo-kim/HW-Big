//20.12.15 kks wrapper
package com.lec.ex11_wrapper;
// 가변인자함수
public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10","20","30","40");
		System.out.println("들어온 값의 합계는 "+total);
	}
	private static int valueSum(String...value) {
		int result=0; //누적함수
		for(int i=0;i<value.length;i++) {
			//Integer.parseInt(val) : val문자열을 정수로 바꿔준다.
			result +=Integer.parseInt(value[i]);
		}
		return result;
	}
}
