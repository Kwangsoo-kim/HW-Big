//201221 kks gui_awt
package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02_MyFrame extends Frame implements ActionListener {
	private Label lbl1; // �߰��� ������Ʈ ������ ����
	private Button btnExit;

	public Ex02_MyFrame() {
		// �����ӿ� �󺧰� ��ư �߰��� setVisible�� setSize
		setLayout(new FlowLayout()); // �������� layout ��Ÿ���� flowLayout()���� - add������� ��������迭
		// setLayout(new BorderLayout()); - �⺻ Layout
		// setLayout(new GridLayout(2,2)); - 2�� 2��¥�� ���� Layout
		lbl1 = new Label("��ſ� ������");
		lbl1.setPreferredSize(new Dimension(150, 200)); // ������Ʈ ������
		btnExit = new Button("����");
		btnExit.setPreferredSize(new Dimension(200, 200));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500, 300));
		setLocation(100, 100);
		btnExit.addActionListener(this); //** btnExit Ŭ���̺�Ʈ�� �߻��ϸ� this.actionperfomed(btnExit)ȣ��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

	}

	public Ex02_MyFrame(String title) {
		this();
		setTitle(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ó�� �޼ҵ�
		// btnExit Ŭ���̺�Ʈ�� �߻��ϸ� this.actionperfomed(btnExit)ȣ��
		if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex02_MyFrame("�� ��° GUI ����");
	}
}
