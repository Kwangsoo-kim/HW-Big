//201217 kks exemple
package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerMain {
	public static void main(String[] args) {
		String pn;
		String n;
		String add;
		String t;
		Scanner sc = new Scanner(System.in);
		HashMap<String,Customer> hm = new HashMap<String, Customer>();
		while(true) {
			System.out.println("ȸ�������� ���Ͻó���?(Y/n)");
			t = sc.next();
			if(t.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��� �ּ���");
				n = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��� �ּ���");
				pn = sc.next();
				System.out.println("�ּҸ� �Է��� �ּ���");
				sc.nextLine();
				add = sc.nextLine();
				hm.put(pn, new Customer(n, pn, add));
			}else if(t.equalsIgnoreCase("n")) {
				break;
			}
		}
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(hm.get(key));
		}
		sc.close();
	}
}
