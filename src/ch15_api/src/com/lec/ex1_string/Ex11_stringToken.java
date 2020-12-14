package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex11_stringToken {
	public static void main(String[] args) {
		String str1 ="정해인 유준상 강동원 김육석 하정우";
		String str2 = "2020/12/14";
		
		StringTokenizer tk1 = new StringTokenizer(str1);// space, \t,\n 단위로 token나눔
		StringTokenizer tk2 = new StringTokenizer(str2,"/"); //token으로 나눌 기호입력
		System.out.println("tk1의 token 갯수 : "+ tk1.countTokens());
		while(tk1.hasMoreTokens()) {
			System.out.println(tk1.nextToken());
		}
		System.out.println("tk2의 token 갯수 : "+ tk2.countTokens());
		while(tk2.hasMoreElements()) {
			System.out.println(tk2.nextToken());
		}
	}
}
