//201218 kks it_dataOutputStream
package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_dataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null; // ������Ʈ���� �⺻��Ʈ���� �־�� ��밡���ϴ�.
		try {// ������Ʈ���� �⺻��Ʈ���� ���ؼ��� ���� ����.
			fos = new FileOutputStream("txtFile/dataFile.dat");//java�θ� �о���� �� �ִ�.
			dos = new DataOutputStream(fos); // ������ ������ ���°� ����
			dos.writeUTF("ȫ�浿"); // ��Ʈ�� ����
			dos.writeInt(2);// int�� ����
			dos.writeDouble(95.9); //double�� ����
			System.out.println("���� �Ϸ� ");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(dos!=null) {
					dos.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
