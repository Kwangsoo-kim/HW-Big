//201221 kks gui_awt
package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.WindowListener;

public class Ex03_Login extends Frame {
	private Label lbl1;
	private TextField txtid;
	private Label lbl2;
	private TextField txtpw;
	private Button btnlogin;
	public Ex03_Login(String title) {
		super(title);
		setLayout(new FlowLayout()); //Frame�� Layout����
		lbl1 = new Label("���̵�");
		txtid = new TextField("ID",20); 
		lbl2 = new Label("��й�ȣ");
		txtpw = new TextField("",20);
		txtpw.setEchoChar('*');  // Ÿ���� �� �� *�� ���̰�
		btnlogin = new Button("Login");
		add(lbl1);
		add(txtid);
		add(lbl2);
		add(txtpw);
		add(btnlogin);
		setVisible(true);
		setSize(new Dimension(300,150));
		setResizable(false); //����ڰ� frame size ���� �Ұ��ϰ�.
		setLocation(100,100);
		
	}
	public static void main(String[] args) {
		new Ex03_Login("�α��� ȭ��");
	}

}
