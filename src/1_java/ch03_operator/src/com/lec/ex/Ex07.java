package com.lec.ex;
//��Ʈ ������ : &, |
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10;       //01010 ������
		int n2 = 5;        //00101 ������
		int result = n1&n2;
		System.out.printf("%d %c %d = %d\n", n1, '&', n2, result);
		//00000  - ���� ���� ���� ���� ����, ������ true �ٸ��� false�� 0 and�������� �ٸ��� �� 0 
		result = n1 | n2;
		System.out.printf("%d %c %d = %d\n", n1, '|', n2, result);
		//01111 -  ���� ���� ���� ���� ���� , or�̱� ������ ���� 1�� ������ �״�� �����´�.
		
		
			}

}
