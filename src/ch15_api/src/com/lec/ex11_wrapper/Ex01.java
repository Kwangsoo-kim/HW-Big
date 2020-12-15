//20.12.15 kks wrapper
package com.lec.ex11_wrapper;
//wrapper는 객체 데이터지만 기초 데이터처럼 사용가능.
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) {
			System.out.println("i와j는 같다");
		}
		Integer obj1 = new Integer(10);
		Integer obj2 = new Integer(10);
		if("Hello".equals(new Integer(10))) {
			System.out.println("같다.");
		}else {
			System.out.println("같지 않다.");
		}
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2의 데이터는 같다");
		}
		//int total = obj1.intValue()+obj2.intValue();
		int total = obj1+obj2;
	}
}
