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
			os = new FileOutputStream("txtFile/2.txt"); //1.������ ����.
			byte[] bs = {'H','e','l','l','o','\r','\n','J','A','V','A'};
			for(int i=0;i<bs.length;i++) { 
				os.write(bs[i]);//2.���� ������ ����.
			}
			System.out.println("����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			
				try {
					if(os!=null) {
					os.close();  //3. ���� �ݴ´�.
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
