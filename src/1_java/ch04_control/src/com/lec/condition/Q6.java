package com.lec.condition;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ������");
		int mon = sc.nextInt();
//switch��		
		switch(mon) {
		case 12:
			System.out.println("�ܿ��Դϴ�."); break;
		case 11:
			System.out.println("�ܿ��Դϴ�."); break;
		case 10:
			System.out.println("�ʰ����Դϴ�."); break;
		case 9:
			System.out.println("�����Դϴ�."); break;
		case 8:
			System.out.println("�����Դϴ�."); break;
		case 7:
			System.out.println("�����Դϴ�."); break;
		case 6:
			System.out.println("�����Դϴ�."); break;
		case 5:
			System.out.println("���Դϴ�."); break;
		case 4:
			System.out.println("���Դϴ�."); break;
		case 3:
			System.out.println("���Դϴ�."); break;
		case 2:
			System.out.println("�ܿ��Դϴ�."); break;
		case 1:
			System.out.println("�ܿ��Դϴ�."); break;
		default:
			System.out.println("����");
		}
//if��		
		if(mon==11 || mon==12 || mon==1 || mon==2) {
			System.out.println("�ܿ��Դϴ�.");
		}else if(mon==9 || mon==10) {
			System.out.println("�����Դϴ�.");
		}else if(mon==6 || mon==7 || mon==8) {
			System.out.println("�����Դϴ�.");
		}else if(mon==3 || mon==4 || mon==5) {
			System.out.println("���Դϴ�.");
		}else {
			System.out.println("����"); 
		}
		sc.close();
	}
}
