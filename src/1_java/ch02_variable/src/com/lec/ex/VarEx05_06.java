package com.lec.ex;

public class VarEx05_06 {
	public static void main(String[] args) {
		float f;
		double d;
		f = 10.1f; // 0.101*10��2�� :0.101E2
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
			System.out.println("���� ����");
		else
			System.out.println("���� �ٸ���");
		//��������� float������ ���� ����� ���� ����Ȯ �� ���� ��Ÿ �� ���� �ֱ� ������ �ǵ��� double ������ ����.
			
		
	}
}