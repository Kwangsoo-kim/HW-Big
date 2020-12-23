package com.lec.ex;
// 논리연산자 (&&; and , ||; or)
public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		System.out.println("i<j && ++j>h 는 " + (i<j && ++j>h));
		System.out.println("j="+j);

		System.out.println("i>j && ++j>h 는 " + (i>j && ++j>h));
		System.out.println("j="+j); //&&은 앞에 조건이 false면 뒤에 조건은 실행을 생략한다. 그래서 그대로 나옴.
		
		System.out.println("i<j || ++j>h 는 " + (i<j || ++j>h)); 
		System.out.println("j="+j); // ||는 앞에 조건이 true 이면 뒤에 조건은 실행을 생략한다. 그래서 그대로 나옴.

		System.out.println("i>j || ++j>h 는 " + (i>j || ++j>h));
		System.out.println("j="+j);
		
	}

}
