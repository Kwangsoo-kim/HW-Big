//201218 kks io_example
package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex04_ProducList {
	public static void main(String[] args) {
		InputStream is = null;
		DataInputStream dis = null;
		ArrayList<Product> al = new ArrayList<Product>();
		try {
			is = new FileInputStream("txtFile/product.dat");
			dis = new DataInputStream(is);
			while (true) {
				String na = dis.readUTF();
				int pr = dis.readInt();
				int ps = dis.readInt();
				al.add(new Product(na, pr, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (IOException e) {
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				System.out.println("3" + e.getMessage());
			}
		}
		System.out.println("물건명" + "\t가격" + "\t재고갯수");
		for (Product t : al) {
			System.out.println(t);
		}
		System.out.println("이상" + al.size() + "가지 물품 입력됨");
	}
}
