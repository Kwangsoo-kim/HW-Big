package com.lec.ex05shape;

public class TestMain {
	public static void main(String[] args) {
//		Shape s1 = new Circle(5);
//		Shape s2 = new Rectangle(10, 5);
//		Shape s3 = new Triangle(5, 10);
		Shape[] s = {new Circle(5),
					 new Rectangle(10, 5),
					 new Triangle(5, 10)
		};
//		for(int i=0; i<=s.length;i++) {  <=�� �����鼭 ���ܹ߻�(����ܰ� ����), ������ �ǳ� �����߻���.
//			s[i].draw();
//			s[i].computeArea();
//		}
		for(Shape i: s) {
			i.draw();
			System.out.println("������ ���̴� : "+i.computeArea());
		}
	}
}

