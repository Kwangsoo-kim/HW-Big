//201216 kks example
package com.lec.ex5_book;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =new SimpleDateFormat("YYYY�� MM�� dd��(E)");
		String bt;
		String cod;
		String br;
		int fn = -1;
		int i;
		BookLib b1 = new BookLib("890r-01", "java", "�ڹٸ�");
		BookLib b2 = new BookLib("190c-05", "hadoop", "�ϵӸ�");
		BookLib b3 = new BookLib("230r-03", "r", "�˸�");
		BookLib[] b = { new BookLib("890r-01", "java", "�ڹٸ�"), 
				new BookLib("190c-05", "hadoop", "�ϵӸ�"),
				new BookLib("230r-03", "r", "�˸�"), 
				new BookLib("340s-08", "pyton", "���̽��") };
		do {
			System.out.println("���ϴ� �޴��� �Է��ض� 1.����  2.�ݳ�  0.������Ȳ");
			try {	
				fn = sc.nextInt();
			}catch(java.util.InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("����");
				break;
			}
			if (fn == 1) {
				System.out.println("������ ���ϴ� å �̸��� �Է��Ͻÿ�");
				bt = sc.next();
				for (i = 0; i < b.length; i++) {
					if (bt.equals(b[i].getBtt())) {
						b[i].prints();
						break;
					}
				}
				if (i == b.length) {
					System.out.println("å�̸��� �˻����� �ʽ��ϴ�. �ٽ� �Է��� �ּ���");
					continue;
				}
				if (b[i].getState() == 0) {
					System.out.println("���� �Ͻô� �� ������ �Է����ּ���");
					br = sc.next();
					System.out.println("���� �Ͻô� ��¥�� �Է����ּ���");
					cod = sc.next();
					try {
						b[i].cOt(br);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("�������� �����Դϴ�. ����Ұ��� �Դϴ�.");
				}
			} else if (fn == 2) {
				System.out.println("�ݳ��� ���ϴ� å�� �̸��� ������");
				bt = sc.next();
				for (i = 0; i < b.length; i++) {
					if (bt.equals(b[i].getBtt())) {
						break;
					}
				}
				if (i == b.length) {
					System.out.println("å �̸��� �˻����� �ʽ��ϴ�. �ٽ� �������ּ���");
					continue;
				}
				if (b[i].getState() == 1) {
					try {
						System.out.println(
								b[i].getBrr() + "�� " + sdf.format(b[i].getCod()) + "�� �����ذ��� " + b[i].getBtt() + " " + "�ݳ��Ǿ����ϴ�.");
						b[i].cIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else if (b[i].getState() == 0) {
					System.out.println("����� å�� �ƴմϴ�. �ٽ� �������ּ���.");
				}
			} else if (fn == 0) {
				for (BookLib bs : b) {
					bs.prints();
				}
			}//if
		} while (fn == 0 || fn == 1 || fn == 2);  //do

	} //main
} //class
