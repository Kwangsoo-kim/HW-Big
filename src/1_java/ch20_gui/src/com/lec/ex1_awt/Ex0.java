//201221 kks gui_awt
package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame f = new Frame("title");
		Button btn = new Button("��ư");
		Button btn1 = new Button("�׳� ��ư");
		f.add(btn,BorderLayout.NORTH);
		f.add(btn1,BorderLayout.CENTER);
		f.setSize(new Dimension(300,200));
		f.setLocation(100, 50);
		f.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		f.setVisible(false); 	//ȭ�鿡�� �Ⱥ��̰�
		f.dispose(); 			//�������� ��� �ڿ��� ���� 
		System.exit(0);			//��������
	}
}
