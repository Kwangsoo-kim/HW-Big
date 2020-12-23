//201217 kks io_inputStream
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.파일을 연다(스트림객체생성) 2.데이터를 읽는다.(1byte단위로 반복) 3.파일을 닫는다.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null; //finally에서 닫아야하기 때문에 try절 밖으로 빼낸다.
		try {
			is = new FileInputStream("txtFile/1.txt");  //1단계 : 파일을 연다. 절대경로도 가능,상대경로도 가능.
			
			while(true) {// 2. 데이터 읽기(1byte단위로 반복)
				int i = is.read();
				if(i==-1) break;
				System.out.print((char)i);
				//System.out.println((char)i+"- 아스키코드값 : "+i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally { //3.파일을 닫는다.  무조건 닫아야되기 때문에 어떤 상황이 나오던 처리해야함으로 finally에 입력.
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {}
		}//try-catch-finally
	}//main
}//class
