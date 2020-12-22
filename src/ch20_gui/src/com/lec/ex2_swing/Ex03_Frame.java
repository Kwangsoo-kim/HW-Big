//201222 kks gui_swing
package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_Frame extends JFrame implements ActionListener {
	private Container con;
	private JPanel p1;
	private JLabel lbln;
	private JLabel lblt;
	private JLabel lbla;
	private JTextField txtn;
	private JTextField txtt;
	private JTextField txta;
	private ImageIcon icon;
	private JButton btno;
	private JTextArea txto;
	private JScrollPane sb;

	public Ex03_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con = getContentPane();
		con.setLayout(new BorderLayout());
		p1 = new JPanel(new GridLayout(3, 2)); // 3��2�� grid
		lbln = new JLabel("�� ��", (int) CENTER_ALIGNMENT);
		lblt = new JLabel("�� ȭ", (int) CENTER_ALIGNMENT);
		lbla = new JLabel("�� ��", (int) CENTER_ALIGNMENT);
		txtn = new JTextField();
		txtt = new JTextField();
		txta = new JTextField();
		icon = new ImageIcon("icon/output.png");
		btno = new JButton("���", icon);
		txto = new JTextArea(5, 30); // 5������ 30�ڱ��� ���
		sb = new JScrollPane(txto); // txto�� �ӱ��� Scroll
		p1.add(lbln);
		p1.add(txtn);
		p1.add(lblt);
		p1.add(txtt);
		p1.add(lbla);
		p1.add(txta);
		con.add(p1, BorderLayout.NORTH);
		con.add(btno, BorderLayout.CENTER);
		con.add(sb, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(100,100);				setbounds�� ���հ���.
		setBounds(100, 100, 400, 300);
		btno.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btno) {
			String name = txtn.getText().trim();
			String tel = txtt.getText().trim();
			if (name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ݵ�� �Է�");
				return;
			}
			int age;
			try {
				age = Integer.parseInt(txta.getText());
			}catch (NumberFormatException er) {
				age = -1;
			}
			String result = "[�̸�]"+name+"\t[��ȭ]"+tel;
			if(age>=0 && age<130) {
				result += "\t[����]"+age;
			}else {
				result += "\t[����]��ȿ���� �ʴ� ���̸� �Է�";
			}
			System.out.println(result);
			txto.append(result+"\r\n");
			txtn.setText("");
			txtt.setText("");
			txta.setText("");
		}

	}

	public static void main(String[] args) {
		new Ex03_Frame("GUI����");
	}
}
