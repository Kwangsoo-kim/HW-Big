package com.lec.loop;
//��ǻ�Ͱ� ������ �ζ� ��ȣ ���߱�
import java.util.Scanner;

public class Ex10_dowhile {
	public static void main(String[] args) {
//		System.out.println(Math.random());   // 0�̻� 1�̸��� ���� �Ǽ��� �߻�  : Math.random()
//		System.out.println(Math.random()*45);// 0�̻� 45�̸��� ���� �Ǽ��� �߻� :Math.random()*45
//		System.out.println((int)(Math.random()*45));//0~44�̻��� ���� ������ �߻�
//		System.out.println((int)(Math.random()*45)+1);//1~45�̻��� ���� ������ �߻�
		Scanner sc = new Scanner(System.in);
		int lotto = (int)(Math.random()*45)+1;  // ��ǻ�Ͱ� ������ �ζ� ��ȣ
		int su; //����ڿ��� �Է¹��� ���� �����ϴ� ����
		do {
			System.out.print("�ζ� ��ȣ�� �� �� �˾Ƹ��� ������");
			su = sc.nextInt();
			if(su>lotto){
				System.out.println(su+"���� ���� ���� �����ϼ���");
			}else if(su<lotto) {
				System.out.println(su+"���� �� ū ���� �����ϼ���");
			}
		}while(su!=lotto);
		System.out.println("�����Դϴ�.");
	}
}
