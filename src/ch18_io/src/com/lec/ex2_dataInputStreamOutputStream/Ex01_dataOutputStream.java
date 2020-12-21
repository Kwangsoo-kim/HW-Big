//201218 kks it_dataOutputStream
package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_dataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null; // 보조스트림은 기본스트림이 있어야 사용가능하다.
		try {// 보조스트림은 기본스트림을 통해서만 생성 가능.
			fos = new FileOutputStream("txtFile/dataFile.dat");//java로만 읽어들일 수 있다.
			dos = new DataOutputStream(fos); // 데이터 단위로 쓰는게 목적
			dos.writeUTF("홍길동"); // 스트링 저장
			dos.writeInt(2);// int값 저장
			dos.writeDouble(95.9); //double값 저장
			System.out.println("저장 완료 ");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(dos!=null) {
					dos.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
