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
//		for(int i=0; i<=s.length;i++) {  <=를 넣으면서 예외발생(실행단계 에러), 실행은 되나 에러발생됨.
//			s[i].draw();
//			s[i].computeArea();
//		}
		for(Shape i: s) {
			i.draw();
			System.out.println("도형의 넓이는 : "+i.computeArea());
		}
	}
}

