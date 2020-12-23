//20.12.15 kks wpapper
package com.lec.ex11_wrapper;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("스트링을 정수 : Integer.parseInt(문자열)");
		int i = Integer.parseInt("123");
		System.out.println(i);
		System.out.println("정수를 스트링 : ");
		//어제는 String monthString = ""+12;
		String monthString = String.valueOf(12);
		System.out.println(monthString);
	}
}
