package com.lec.ex01_string;

public class Ex08 {
	public static void main(String[] args) {
		String str1 = "월드컵";
		String str2 = "월드컵";
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소");
		}else {
			System.out.println("str1과 str2는 다른 주소");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		str1 = str1.concat("2002");//str1 =str1+"2002";
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소");
		}else {
			System.out.println("str1과 str2는 다른 주소");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//String은 생성시 새로운 메모리를 차지한다.단점
	}
}
