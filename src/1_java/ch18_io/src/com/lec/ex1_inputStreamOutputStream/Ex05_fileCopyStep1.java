//201218 kks io_copy
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. ��Ʈ����ü����(inputStream,ouputStream) 2.�а���(�ݺ�) 3.��Ʈ���ݱ�
public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/copyex.jpg"); // �Է�
			os = new FileOutputStream("txtFile/copyex2.jpg"); // ���
			int cnt = 0;
			while (true) {
				++cnt;
				int i = is.read(); // 1byte �б�
				if (i == -1) {
					break;
				}
				os.write(i);// 1byte ����
			}
			System.out.println(cnt + "�� �ݺ� �� ���� ���� ����"); // �ӵ��� ������~
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