package com.lec.loop;
// i�� 1��  �� �������� x�̴�.(i�� 1~10)
public class Ex08_while {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		int sum2 = 0;
		while(i<=10) {
			sum += i; // sum= sum+i;
			System.out.printf("i�� %d�� �� �������� %d�̴�\n",i,sum);
			// ���� �Ȱ���. System.out.println("i�� "+i+"�� �� ��������"+sum+"�̴�");
			++i;
		}
		System.out.println();
		
		for(int j =1; j<11; j++) {
			sum2 += j;
			System.out.printf("j�� %d�� �� �������� %d�̴�\n",j,sum2);
		}
	}
}
