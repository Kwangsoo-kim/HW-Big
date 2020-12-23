package com.lec.ex;
//팩키지가 다르고 클래명이 같은때 처음 임폴트한 것은 임폴트되어 축약되어 표시되고,
//그다음 임폴트 해야하는 클래스는 풀네임을 입력해야 사용 가능하다.
import com.acom.ex.Emp;

public class TestMain {
	public static void main(String[] args) {
		Emp e1 = new Emp(101);    //acom 것
		com.bcom.ex.Emp e2 = new com.bcom.ex.Emp();     //bcom 것
	}
}
