package com.acom.ex;

public class Emp {
	private int no;
	public Emp(int no) {
		this.no=no;
	}
	public void setNo(int no) {    //단축기 set변수명 맨앞 문자 + 컨트롤,스페이스
		this.no = no;
	}public int getNo() {   //단축기 get변수명 맨앞 문자 + 컨트롤,스페이스
		return no;
	}
}
