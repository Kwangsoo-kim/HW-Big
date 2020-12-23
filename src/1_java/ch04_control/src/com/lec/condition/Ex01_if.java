package com.lec.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int i = 10, j= 20, h = 31;
		if(i+j == h) //if 문은 무조거 블록을 씌우자 {} 요거 
		{
			System.out.println("i+j는 h 입니다");
			System.out.println("그럼 같지");
			}
		if(i>j) {
			System.out.println("i>j입니다");
		}else {
			System.out.println("i>j가 아닙니다.");
		}
	}
}
