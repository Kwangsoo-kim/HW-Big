package com.lec.square;
//square s1 = new square()
//square s2 = new square(10);
public class Square {
	private int side;
	public Square() {
		System.out.println("�Ű����� ���� ������ ȣ���");
	} //(�Ű����� ���� ������)   //**�Ϲ������� ������ �Լ��� ������ �ʱ�ȭ�� ��Ű�� ������ �Ѵ�. 
	//������ ������ �ִ°��� ������ �����ε��̶�� �մϴ�.
	
	public Square(int side) {  //�Ű�������int side�� �����͸� �ʱ�ȭ 
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ ȣ���");
	}
	public int area() {
		return side*side;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) { // return ���� �������� void
		this.side = side;
	}
}
