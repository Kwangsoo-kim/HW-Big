//201218 kks io_dataInputStream
package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_dataInputStream {
	public static void main(String[] args) {
		InputStream is = null;
		DataInputStream dis = null;
		try {
			is = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(is);
			String na = dis.readUTF();
			int g = dis.readInt();
			double s = dis.readDouble();
			System.out.println("파일로부터 입력 받은 값은 " + na + "\t" + g + "\t" + s);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
