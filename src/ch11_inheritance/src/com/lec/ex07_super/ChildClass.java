package com.lec.ex07_super;

public class ChildClass extends ParentClass{
	private String cStr = "자식 클래스";
	public ChildClass() {
		System.out.println("자식 생성자");
	}
	@Override
	public void getMaminame() {
		//super. : 부모클래스에서 만들어진 객체의            **위치의 제약이 없다
		//super() : 부모클래스의 생성자                       **반드시 맨 윗 줄에만 써야함.
		System.out.print("이쁜 아주 이쁜 ");
		super.getMaminame();
	}
	public String getcStr() {
		return cStr;
	}
	public void setcStr(String cStr) {
		this.cStr = cStr;
	}

}
