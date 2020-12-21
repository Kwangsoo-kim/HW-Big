//201217 kks io_outputstream
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os=null;
		try {
			os=new FileOutputStream("txtFile/3.txt");  //1단계  txt,ture는 파일에추가해준다.
			String str ="Hello, World.\r\n 모두 다 안녕이 필요한 시국";
			byte[] bs = str.getBytes(); //스트링을 바이트배열로 바꿔준다.
			os.write(bs); //2단계
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) {
				os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
