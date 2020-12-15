package com.lec.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java"); //무조건 객체생성
		String srt4 = new String("java");
		if(str1==str2) {
			System.out.println("st1과str2는 같은 주소");
		}else {
			System.out.println("str1과str2는 다른 주소");
		}
		str1 ="java2";
		if(str1==str2) {
			System.out.println("st1과str2는 같은 주소");
		}else {
			System.out.println("str1과str2는 다른 주소");
		}
		if(str1==str3) {
			System.out.println("str1과 str3은 같은 주소");
		}else {
			System.out.println("str1과str3은 다른 주소");
		}
		System.out.println(str1.hashCode());
		System.out.println("str2와 str3은 같은 스트링이냐?"+(str2.equals(str3)? "같다" : "다르다"));
	}
}
