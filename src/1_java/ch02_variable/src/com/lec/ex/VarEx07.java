package com.lec.ex;
// 형변환 = 무기적인 형변환, 명시적인 형변환 
public class VarEx07 {
	public static void main(String[] args) {
		// 묵시적 형변환
		int i1 = 10; //4byte
		long l1= 2200000000L;
		l1= 10; // 8byte에 4byte 짜리 10을 할당하기 위해
				// 4byte 짜리 10이 8byte 짜리 long형으로 묵시적인 형변환을 한다.
		double d = i1; // 묵시적 형변환 , 할당할 데이터가  할당 될 영역보다 작을 때 묵시적 형변환이라고 한다.
		// 명시적 형변환
		d = 10.7;
		i1 = (int)d; // 명시적 형변환시에는 데이터 손실이 올 수 있다.
		System.out.print("i1="+i1); // 반올림도 안해준다. 
	}

}
