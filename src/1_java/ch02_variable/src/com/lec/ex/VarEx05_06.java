package com.lec.ex;

public class VarEx05_06 {
	public static void main(String[] args) {
		float f;
		double d;
		f = 10.1f; // 0.101*10의2승 :0.101E2
		d = 10.1;
		System.out.printf("f=%.2f\n", f);
		System.out.printf("d=%.2f\n", d);
		float f1;
		double d1;
		f1 =3.14159265359f;
		d1 =3.14159265359;
		System.out.println(f1);
		System.out.println(d1);
		float f2;
		double d2;	
		f2 = 10.001f;
		d2 = 10.001;
		System.out.println("f2="+f2);
		System.out.println("d2="+d2);
		if(f2==d2)
			System.out.println("둘이 같다");
		else
			System.out.println("둘은 다르네");
		//결론적으로 float변수의 값은 길어질 수록 부정확 한 수를 나타 낼 수도 있기 때문에 되도록 double 변수를 쓰자.
			
		
	}
}