package com.lec.square;
//square s1 = new square()
//square s2 = new square(10);
public class Square {
	private int side;
	public Square() {
		System.out.println("매개변수 없는 생성자 호출됨");
	} //(매개변수 없는 생성자)   //**일반적으로 생성자 함수는 데이터 초기화를 시키는 역할을 한다. 
	//생성자 여러개 있는것을 생성자 오버로딩이라고 합니다.
	
	public Square(int side) {  //매개변수를int side로 데이터를 초기화 
		this.side = side;
		System.out.println("매개변수 있는 생성자 호출됨");
	}
	public int area() {
		return side*side;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) { // return 값이 없음으로 void
		this.side = side;
	}
}
