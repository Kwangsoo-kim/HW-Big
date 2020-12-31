package com.lec.ex;

public class VarEx02_04 {
	public static void main(String[] args) {
		//변수선언 방법
		//1. 자료형 변수명; 
		int num1; // 선언만 하고 값은 할당 안 함. 결론적으로 값을 할당 해주어야한다.
		num1= 10;
		System.out.println("num1="+num1);
		//2. 자료형 변수명 = 값;
		char c1='씨'; // '' - 문자 한개만 넣을 수 있음. /"" - 문자열 넣을 수 있다.
		System.out.println("c1="+c1);
		//3. 자료형 변수명1, 변수명2, .... 변수명n;
		boolean b1, b2, b3;
		b1=true; b2=false; b3=true;
		System.out.print("b1="+b1+"\t b2="+b2+"\t b3="+b3+"\n");
		//4. 자료형 변수명1=값1, 변수명2=값,....변수명m=값n;
		long l1=2200000000l; //기본은 int, 22억 이상의 정수는 long형으로 할당 가능하나 수 마지막에 L기입해주어야 한다.
		float f1=41.19f , f2=2.24f , f3; //기본은 double. float은 f를 기입해주어야 할당된다.
		System.out.println("f1="+f1+"\t f2"+f2);
		System.out.printf("f1 = %3.1f, f2 = %4.1f\n",f1, f2); 
		//printf로 format 지정 가능 실수형은 %f, 사이에 x.b - x는 몆자리 나타낼 것이냐, b는 소수점 몇자리까지 나타낼 것이냐.
		// %f : 실수, %d : 정수, %c : 문자(1개), %s : 문자열, %x : 16진수(잘 안쓴다)
		System.out.println("프로그램 끝");      // println - 자동개행 , \n - 개행해주는 명령어
	}//프로그램 끝

}//Class 끝
