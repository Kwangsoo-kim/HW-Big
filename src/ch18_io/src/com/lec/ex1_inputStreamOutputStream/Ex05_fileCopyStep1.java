//201218 kks io_copy
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. 스트림객체생성(inputStream,ouputStream) 2.읽고쓰기(반복) 3.스트림닫기
public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/copyex.jpg"); // 입력
			os = new FileOutputStream("txtFile/copyex2.jpg"); // 출력
			int cnt = 0;
			while (true) {
				++cnt;
				int i = is.read(); // 1byte 읽기
				if (i == -1) {
					break;
				}
				os.write(i);// 1byte 쓰기
			}
			System.out.println(cnt + "번 반복 후 파일 복사 성공"); // 속도가 느리다~
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