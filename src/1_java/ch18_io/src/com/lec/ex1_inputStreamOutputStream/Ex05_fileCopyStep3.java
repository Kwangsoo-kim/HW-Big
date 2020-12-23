//201218 kks io_copy
package com.lec.ex1_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_fileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File originalFile = new File("txtFile/copyex.jpg");  //���� ��ü�� ����
//			if(originalFile.exists()) {
//				System.out.println("���� ������");
//			}else {
//				System.out.println("���� �̸��� �߸� �Ǿ����ϴ�. �������� �ʽ��ϴ�.");
//			}
			is = new FileInputStream(originalFile); // ���� ��ü�� �Է�
			os = new FileOutputStream("txtFile/copyex4.jpg"); // ���
			int cnt = 0;
			byte[] bs = new byte[(int) originalFile.length()]; //���� ��ü ũ�� ��ü�� ����
			while (true) {
				++cnt;
				int rbc = is.read(bs); // 1byte �б�
				if (rbc == -1) {
					break;
				}
				//bs�迭�� 0�� index���� rbc ����Ʈ ��ŭ�� ���Ͽ� ����
				os.write(bs,0,rbc);// 1byte ����
			}
			System.out.println(cnt + "�� �ݺ� �� ���� ���� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null && os != null) {
					os.close();
					is.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}