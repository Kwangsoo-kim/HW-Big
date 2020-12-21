//201217 kks io_outputstream
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/2.txt"); //1.파일을 연다.
			byte[] bs = {'H','e','l','l','o','\r','\n','J','A','V','A'};
			for(int i=0;i<bs.length;i++) { 
				os.write(bs[i]);//2.파일 데이터 쓰기.
			}
			System.out.println("성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			
				try {
					if(os!=null) {
					os.close();  //3. 파일 닫는다.
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
