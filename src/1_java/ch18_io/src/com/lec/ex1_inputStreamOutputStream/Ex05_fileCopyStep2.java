//201218 kks io_copy_1kbyte
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_fileCopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/copyex.jpg"); // �Է�
			os = new FileOutputStream("txtFile/copyex3.jpg"); // ���
			int cnt = 0;
			byte[] bs = new byte[1024]; //1kbyte�� �� �迭�� �о� ���̴� ���� ����.
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