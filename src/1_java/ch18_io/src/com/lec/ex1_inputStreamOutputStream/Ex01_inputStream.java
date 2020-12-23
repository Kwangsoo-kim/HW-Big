//201217 kks io_inputStream
package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.������ ����(��Ʈ����ü����) 2.�����͸� �д´�.(1byte������ �ݺ�) 3.������ �ݴ´�.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null; //finally���� �ݾƾ��ϱ� ������ try�� ������ ������.
		try {
			is = new FileInputStream("txtFile/1.txt");  //1�ܰ� : ������ ����. �����ε� ����,����ε� ����.
			
			while(true) {// 2. ������ �б�(1byte������ �ݺ�)
				int i = is.read();
				if(i==-1) break;
				System.out.print((char)i);
				//System.out.println((char)i+"- �ƽ�Ű�ڵ尪 : "+i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally { //3.������ �ݴ´�.  ������ �ݾƾߵǱ� ������ � ��Ȳ�� ������ ó���ؾ������� finally�� �Է�.
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {}
		}//try-catch-finally
	}//main
}//class
