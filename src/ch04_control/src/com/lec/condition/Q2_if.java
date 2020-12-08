package com.lec.condition;

public class Q2_if {
	public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max;
		if(num1>num2){
			 max = num1;
		} else {
			 max = num2;
		}
		System.out.println(max);
	    }
//if 변수 안에서 정의된 변수는 프로그램 실행 후 if절을 빠져나오면 삭제된다. 따라서 main에 변수를 잡아두고 실행해야한다. 

}
