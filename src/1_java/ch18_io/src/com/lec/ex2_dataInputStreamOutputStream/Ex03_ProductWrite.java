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
				System.out.println("제품을 입력하시겠습니까?(Y/N)");
				fn = sc.next();
				if (fn.equalsIgnoreCase("y")) {
					System.out.println("물건명을 입력해 주세요");
					na = sc.next();
					dos.writeUTF(na);
					System.out.println("가격을 입력해 주세요");
					pr = sc.nextInt();
					dos.writeInt(pr);
					System.out.println("수량을 입력해 주세요");
					ps = sc.nextInt();
					dos.writeInt(ps);
					sc.nextLine();
					System.out.println("저장왼료");
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
