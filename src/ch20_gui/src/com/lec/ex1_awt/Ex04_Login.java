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
		setLayout(new BorderLayout()); //기본값이라 따로 안써도 상관없다.
		p1 = new Panel();
		p1.setLayout(new GridLayout(2,2)); // 2행 2열
		txtid = new TextField("ID",20);
		txtpw = new TextField(20);
		txtpw.setEchoChar('*');
		btnlogin = new Button("로그인");
		//넣은 순서대로 정렬
		p1.add(new Label("아 이 디",(int)CENTER_ALIGNMENT));
		p1.add(txtid);
		p1.add(new Label("비밀번호",(int)CENTER_ALIGNMENT));
		p1.add(txtpw);
		add(p1,BorderLayout.NORTH);
		add(btnlogin,BorderLayout.SOUTH);
		setSize(new Dimension(300, 200));
		setLocation(150, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex04_Login("로그인 화면");
	}
}
