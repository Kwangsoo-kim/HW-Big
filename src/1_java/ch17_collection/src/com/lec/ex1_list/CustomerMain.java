//201217 kks exemple
package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMain {
	public static void main(String[] args) {
		String a;
		String b;
		String c;
		String fs;
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> al = new ArrayList<Customer>();
		do {
			
			System.out.println("ȸ������ �Ͻðڽ��ϱ�?(Y/N)");
			fs = sc.next();
			if(fs.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��� �ּ���");
				a = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��� �ּ���");
				b = sc.next();
				System.out.println("�ּҸ� �Է��ϼ���");
				sc.nextLine();
				c = sc.nextLine();
				al.add(new Customer(a,b,c));
			}else if(fs.equalsIgnoreCase("n")) {
				break;
			}
			
		}while(true);
		System.out.println("���Ե� ȸ�� ���");
		for(Customer t : al) {
			System.out.println(t);
		}
		sc.close();
	}
}
