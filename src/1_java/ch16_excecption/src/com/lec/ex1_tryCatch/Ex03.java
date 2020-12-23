//201216 kks exception
package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;
//����ó���� �ּ����� ��ϸ� ������� ����. 
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int j=1;
		do {
			try {
				System.out.println("ù ��° ���� ?");
				i = sc.nextInt();
				break;
			}catch(java.util.InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("ù���� ���� ���ڸ� ���� ������");
				sc.nextLine(); //���۸� ����� ����.
			}
		}while(true);
		
		System.out.println("�� ��° ���� ?");
		try {
			j = sc.nextInt();
			System.out.println("i = "+i+", j= "+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j));
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage()+"0���� ������ ���� �н�");
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("�� ��° ���� �߸��Է��ϼż� 1�� �ʱ�ȭ");
			sc.nextLine();
		}//�Ϲ������� try�ȿ� try���� ���� �ʴ´�
		//catch���� �ټ��϶��� �ڼ� �θ������ �迭�ؾ��Ѵ�.
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
