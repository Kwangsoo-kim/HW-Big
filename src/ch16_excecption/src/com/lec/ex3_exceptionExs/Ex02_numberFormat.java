//201216 kks exceptions
package com.lec.ex3_exceptionExs;

public class Ex02_numberFormat {
	public static void main(String[] args) {
		String str1 = "10100 "; //스페이스바 붙이면 밟생
		int i=0;
		try {
			 i = Integer.parseInt(str1.trim()); //trim붙이면 된다
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(i);
	}
}
