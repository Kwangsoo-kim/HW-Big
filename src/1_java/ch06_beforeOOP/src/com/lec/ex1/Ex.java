package com.lec.ex1;
import com.lec.ex.Arithmetic; // 다른 패키지에 있으면 import 해주어야 사용가능하다.
public class Ex {
	public static void main(String[] args) {
		Arithmetic ar =new Arithmetic();
		System.out.println("합은 "+ar.sumhod(20));
	}
}
