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
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X��ư ������ ����.
		p1 = (JPanel)getContentPane(); //�����̳�(������)�� ���´�.
		p1.setLayout(new FlowLayout());  //�⺻��
		lbl = new JLabel("��ſ� ������",(int)CENTER_ALIGNMENT);
		lbl.setPreferredSize(new Dimension(150, 200));
		btn = new JButton("����");
		btn.setPreferredSize(new Dimension(200, 200));
		p1.add(lbl);
		p1.add(btn);
		setVisible(true);
		pack(); //�ּ����� ����� ���³��ش�. ���Ƿ� ������ setsize();
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
		new Ex01_Frame("ù ��������");
	}

}
