package com.lec.ex;
// ���������(+,=,*,/,%)
public class Ex01 {
	public static void main(String[] args){
		int n1 = 33, n2 = 10;
		int result;
		double resultDouble;
		result = n1+n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1-n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1*n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1/n2; //������ ���� 0�� �ƴϾ�� �Ѵ�. 4byte������ ������ 4byte�� ���´�.
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.1f\n", n1, '/', n2, resultDouble);
		result = n1%n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		// ������ �������� ���ӻ�
		if (n1%2==0)
			System.out.println("¦��");
		else
			System.out.println("Ȧ��");
		
	}//���α׷���

}//class��