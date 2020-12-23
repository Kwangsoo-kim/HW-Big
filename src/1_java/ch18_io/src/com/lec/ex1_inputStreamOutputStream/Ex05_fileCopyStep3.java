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
			File originalFile = new File("txtFile/copyex.jpg");  //파일 객체를 생성
//			if(originalFile.exists()) {
//				System.out.println("파일 존재함");
//			}else {
//				System.out.println("파일 이름이 잘못 되엇습니다. 존재하지 않습니다.");
//			}
			is = new FileInputStream(originalFile); // 파일 객체를 입력
			os = new FileOutputStream("txtFile/copyex4.jpg"); // 출력
			int cnt = 0;
			byte[] bs = new byte[(int) originalFile.length()]; //파일 객체 크기 자체를 읽음
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