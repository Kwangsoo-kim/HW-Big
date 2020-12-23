package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-1234-1234",
				"010-9999-9999",
				"010-8888-8888"};
		Scanner sc= new Scanner(System.in);
		String searchTel;
		int idx; //전화번호가 중복이 없을 떄
		System.out.println("전화번호 뒷자리를 입력해주세여 : ");
		searchTel = sc.next();
		for(idx=0;idx<tels.length;idx++) {
			String t = tels[idx];
			String post = t.substring(t.lastIndexOf("-")+1);
			if(searchTel.equals(post)) {
				System.out.println(t);
				break;
			}//if
		}//for
		if(idx==tels.length) {
			System.out.println("입력하신 전화번호는 없는 번호입니다.");
		}
	}//main
}//class
