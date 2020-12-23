package com.lec.ex1_string;

public class Ex09_stringBuffer {
	public static void main(String[] args) {
		StringBuilder strB = new StringBuilder("abc");
		System.out.println(strB);
		strB.append("def");
		System.out.println(strB);
		strB.insert(3, "aaa"); // 3번인덱스에 "aaa"추가 
		System.out.println(strB);
		strB.delete(3,6); //3번인덱스부터 6번인덱스 앞 까지삭제
		System.out.println(strB);
		int capacitysize = strB.capacity(); //가용크기
		System.out.println("가용크기 : "+capacitysize);
		System.out.println("현 해쉬코드 : "+strB.hashCode());
		strB.append("01234123412341");
		capacitysize = strB.capacity();
		System.out.println("가용크기 변경 : "+capacitysize);
		System.out.println("변경후 strB의 해쉬코드 : "+ strB.hashCode());
		//가용크기를 인위적으로 늘리기
		strB.ensureCapacity(1000);
		capacitysize = strB.capacity();
		System.out.println("가용크기 변경 : "+capacitysize);
		System.out.println("변경후 strB의 해쉬코드 : "+ strB.hashCode());
	}
}
