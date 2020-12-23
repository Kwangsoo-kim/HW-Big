//201222 kks gui_example
package com.lec.ex3_example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container con;
	private JPanel p1;
	private JPanel p2;
	private JLabel lbln;
	private JLabel lblt;
	private JLabel lbla;
	private JTextField txtn;
	private JTextField txtt;
	private JTextField txta;
	private ImageIcon iconi;
	private ImageIcon icono;
	private JButton btni;
	private JButton btno;
	private ArrayList<Person> al ;
	private int a;

	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con = getContentPane();
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 2));
		p2 = new JPanel();
		lbln = new JLabel("이름", (int) CENTER_ALIGNMENT);
		lblt = new JLabel("전화", (int) CENTER_ALIGNMENT);
		lbla = new JLabel("나이", (int) CENTER_ALIGNMENT);
		txtn = new JTextField();
		txtt = new JTextField();
		txta = new JTextField();
		iconi = new ImageIcon("icon/search.png");
		icono = new ImageIcon("icon/search.png");
		btni = new JButton("입력", iconi);
		btno = new JButton("출력", icono);
		p1.add(lbln);
		p1.add(txtn);
		p1.add(lblt);
		p1.add(txtt);
		p1.add(lbla);
		p1.add(txta);
		p2.add(btni);
		p2.add(btno);
		con.add(p1, BorderLayout.NORTH);
		con.add(p2, BorderLayout.SOUTH);
		setVisible(true);
		pack();
		setLocation(200, 200);
		btni.addActionListener(this);
		btno.addActionListener(this);
		al = new ArrayList<Person>();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btni) {
			String n;
			String t;
			int a = 0;
			n = txtn.getText();
			t = txtt.getText();
			if (n.equals("") || t.equals("")) {
				System.out.println("이름과 전화번호는 반드시 입력");
				return;
			}
			try {
				a = Integer.parseInt(txta.getText());
			} catch (NumberFormatException er) {
				a = -1;
			}
			if (a >= 0 && a < 130) {
				a=a;
			} else {
				System.out.println("\t[나이]유효하지 않는 나이를 입력");
				return;
			}
			al.add(new Person(n, t, a));
			txtn.setText("");
			txtt.setText("");
			txta.setText("");
		} else if (e.getSource() == btno) {
			Writer wt = null;
			try {
				wt = new FileWriter("icon/person.txt", true);
				for (Person p : al) {
					System.out.println(p);
					String str = p.toString();
					wt.write(str);
				}

			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					wt.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}

		}
	}

	public static void main(String[] args) {
		new MyFrame("gut예");
	}
}
