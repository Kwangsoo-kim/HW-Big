//201221 kks gui_awt
package com.lec.ex1_awt;

import java.awt.*;

public class Ex04_Login extends Frame {
	private Panel p1;
	private TextField txtid;
	private TextField txtpw;
	private Button btnlogin;
	public Ex04_Login(String title) {
		super(title);
		setLayout(new BorderLayout()); //�⺻���̶� ���� �Ƚᵵ �������.
		p1 = new Panel();
		p1.setLayout(new GridLayout(2,2)); // 2�� 2��
		txtid = new TextField("ID",20);
		txtpw = new TextField(20);
		txtpw.setEchoChar('*');
		btnlogin = new Button("�α���");
		//���� ������� ����
		p1.add(new Label("�� �� ��",(int)CENTER_ALIGNMENT));
		p1.add(txtid);
		p1.add(new Label("��й�ȣ",(int)CENTER_ALIGNMENT));
		p1.add(txtpw);
		add(p1,BorderLayout.NORTH);
		add(btnlogin,BorderLayout.SOUTH);
		setSize(new Dimension(300, 200));
		setLocation(150, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex04_Login("�α��� ȭ��");
	}
}
