package com.lec.loop;

public class Ex05_forBreak {
	public static void main(String[] args) {
		for(int i = 1; i<11; i++) {
			if(i==5) {
				continue; // 증감식으로 가라는 명령어(생략기능?)
				//break; // 반복문 블럭을 빠져나가는 명령어
			}
			System.out.print(i+" ");
		}
	}
}
