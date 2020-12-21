//201218 kks io_example
package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWrite {
	public static void main(String[] args) {
		OutputStream os = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		String fn;
		String na;
		int pr;
		int ps;

		try {
			os = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(os);
			do {
				System.out.println("��ǰ�� �Է��Ͻðڽ��ϱ�?(Y/N)");
				fn = sc.next();
				if (fn.equalsIgnoreCase("y")) {
					System.out.println("���Ǹ��� �Է��� �ּ���");
					na = sc.next();
					dos.writeUTF(na);
					System.out.println("������ �Է��� �ּ���");
					pr = sc.nextInt();
					dos.writeInt(pr);
					System.out.println("������ �Է��� �ּ���");
					ps = sc.nextInt();
					dos.writeInt(ps);
					sc.nextLine();
					System.out.println("����޷�");
				} else if (fn.equalsIgnoreCase("n")) {
					break;
				}
			} while (true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (os != null)
					os.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		sc.close();
	}
}
