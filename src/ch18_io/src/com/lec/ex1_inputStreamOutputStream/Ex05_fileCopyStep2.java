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
			is = new FileInputStream("txtFile/copyex.jpg"); // 입력
			os = new FileOutputStream("txtFile/copyex3.jpg"); // 출력
			int cnt = 0;
			byte[] bs = new byte[1024]; //1kbyte씩 이 배열에 읽어 들이는 것이 목적.
			while (true) {
				++cnt;
				int rbc = is.read(bs); // 1byte 읽기
				if (rbc == -1) {
					break;
				}
				//bs배열에 0번 index부터 rbc 바이트 만큼만 파일에 쓰기
				os.write(bs,0,rbc);// 1byte 쓰기
			}
			System.out.println(cnt + "번 반복 후 파일 복사 성공");
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