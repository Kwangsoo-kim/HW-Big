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
			os=new FileOutputStream("txtFile/3.txt");  //1�ܰ�  txt,ture�� ���Ͽ��߰����ش�.
			String str ="Hello, World.\r\n ��� �� �ȳ��� �ʿ��� �ñ�";
			byte[] bs = str.getBytes(); //��Ʈ���� ����Ʈ�迭�� �ٲ��ش�.
			os.write(bs); //2�ܰ�
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
