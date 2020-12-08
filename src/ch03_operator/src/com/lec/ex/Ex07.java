package com.lec.ex;
//비트 연산자 : &, |
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10;       //01010 이진수
		int n2 = 5;        //00101 이진수
		int result = n1&n2;
		System.out.printf("%d %c %d = %d\n", n1, '&', n2, result);
		//00000  - 서로 같은 라인 값을 대입, 같으면 true 다르면 false로 0 and값임으로 다르면 다 0 
		result = n1 | n2;
		System.out.printf("%d %c %d = %d\n", n1, '|', n2, result);
		//01111 -  서로 같은 라인 값을 대입 , or이기 떄문에 어디든 1이 있으면 그대로 내려온다.
		
		
			}

}
