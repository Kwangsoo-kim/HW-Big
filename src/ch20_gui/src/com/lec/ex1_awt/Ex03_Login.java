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
		setLayout(new FlowLayout()); //Frame의 Layout세팅
		lbl1 = new Label("아이디");
		txtid = new TextField("ID",20); 
		lbl2 = new Label("비밀번호");
		txtpw = new TextField("",20);
		txtpw.setEchoChar('*');  // 타이핑 한 것 *로 보이게
		btnlogin = new Button("Login");
		add(lbl1);
		add(txtid);
		add(lbl2);
		add(txtpw);
		add(btnlogin);
		setVisible(true);
		setSize(new Dimension(300,150));
		setResizable(false); //사용자가 frame size 조정 불가하게.
		setLocation(100,100);
		
	}
	public static void main(String[] args) {
		new Ex03_Login("로그인 화면");
	}

}
