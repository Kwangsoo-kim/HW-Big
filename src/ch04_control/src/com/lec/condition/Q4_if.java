package com.lec.condition;

import java.util.Scanner;


// ����ڷκ��� ����(0) , ����(1), ��(2) �� �ϳ��� �Է¹ް�
// ��ǻ�͵� ����(0),����(1),��(2) �� �ϳ��� �����ؼ� ���ڸ� ���
public class Q4_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����, ����, �� �� �ϳ��� ���� : ");
		int you = sc.nextInt();
		if(you==0) {
			System.out.println("������ ���̳�");
		}else if(you==1) {
			System.out.println("������ ���̳�");
		}else if(you==2) {
			System.out.println("���� ���̳�");
		}else {
			System.out.println("����");
			System.exit(0);
		}
		sc.close();
		int com = (int)(Math.random()*3);
		//Math.random() : 0 ���� 1���� ���� �Ǽ� ������ �߻�
		//System.out.println( (int) (Math.random()*3)); //0~3�̸� ���� �߻�
		if(com==0) {
			System.out.println("��ǻ�ʹ� ����");
		}else if(com==1) {
			System.out.println("��ǻ�ʹ� ����");
		}else {
			System.out.println("��ǻ�ʹ� ��");
		}
//������ ����� ��
		if((you+2)%3==com){
			System.out.println("����� �̰��");
		}else if(you==com) {
			System.out.println("����");
		}else {
			System.out.println("��ǻ�Ͱ� �̰��");
		}
		
		
		
		
 //�ߺ�if ����� ��
		if(you==0) {
			if(com==1) {
				System.out.println("��ǻ�Ͱ���");
			}else if(com==2) {
				System.out.println("����� ��");
			}else {
				System.out.println("���̳׿�");
			}
		}else if(you==1) {
			if(com==1) {
				System.out.println("���̳׿�");
			}else if(com==2) {
				System.out.println("��ǻ�Ͱ� ��");
			}else {
				System.out.println("����� ��");
			}
		}else if(you==2){
			if(com==1) {
				System.out.println("����� ��");
			}else if(com==2) {
				System.out.println("���̳׿�");
			}else {
				System.out.println("��ǻ�Ͱ� ��");
			}
	    }
	}
}
