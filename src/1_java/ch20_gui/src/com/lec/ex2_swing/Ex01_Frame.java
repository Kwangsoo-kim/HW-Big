//201221 kks gui_swing
package com.lec.ex2_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01_Frame extends JFrame implements ActionListener{
	private JPanel p1;
	private JLabel lbl;
	private JButton btn;
	public Ex01_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X버튼 누르면 종료.
		p1 = (JPanel)getContentPane(); //컨테이너(프레임)를 얻어온다.
		p1.setLayout(new FlowLayout());  //기본값
		lbl = new JLabel("즐거운 월요일",(int)CENTER_ALIGNMENT);
		lbl.setPreferredSize(new Dimension(150, 200));
		btn = new JButton("종료");
		btn.setPreferredSize(new Dimension(200, 200));
		p1.add(lbl);
		p1.add(btn);
		setVisible(true);
		pack(); //최소한의 사이즈를 나태나준다. 임의로 조절은 setsize();
		btn.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex01_Frame("첫 스위예제");
	}

}
