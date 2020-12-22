//201222 kks gui_example2
package com.lec.ex4_example2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.acl.LastOwnerException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Homework extends JFrame implements ActionListener {
	private HashMap<String, Customer> hm;
	private Container con;
	private JPanel p1;
	private JPanel p2;
	private JLabel lblt;
	private JLabel lbln;
	private JLabel lblp;
	private JTextField txtt;
	private JTextField txtn;
	private JTextField txtp;
	private JButton btni;
	private JButton btnt;
	private JButton btno;
	private JButton btne;
	private JScrollPane jp;
	private JTextArea txta;

	public Homework(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con = getContentPane();
		con.setLayout(new FlowLayout());
		p1 = new JPanel(new GridLayout(3, 2));
		p2 = new JPanel(new FlowLayout());
		lblt = new JLabel("폰번호", (int) CENTER_ALIGNMENT);
		lbln = new JLabel("이 름", (int) CENTER_ALIGNMENT);
		lblp = new JLabel("포인트", (int) CENTER_ALIGNMENT);
		txtt = new JTextField(15);
		txtn = new JTextField(15);
		txtp = new JTextField(15);
		btni = new JButton("가입");
		btnt = new JButton("폰조회");
		btno = new JButton("출력");
		btne = new JButton("종료");
		txta = new JTextArea(15, 30);
		jp = new JScrollPane(txta);
		p1.add(lblt);
		p1.add(txtt);
		p1.add(lbln);
		p1.add(txtn);
		p1.add(lblp);
		p1.add(txtp);
		p2.add(btni);
		p2.add(btnt);
		p2.add(btno);
		p2.add(btne);
//		p1.setPreferredSize(new Dimension(200, 50));
//		p2.setPreferredSize(new Dimension(350, 30));
//		jp.setPreferredSize(new Dimension(250, 300));
		con.add(p1);
		con.add(p2);
		con.add(jp);
		setVisible(true);
		setBounds(200, 200, 400, 450);
		btni.addActionListener(this);
		btnt.addActionListener(this);
		btno.addActionListener(this);
		btne.addActionListener(this);
		hm = new HashMap<String, Customer>();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btni) {
			String name = txtn.getText();
			String tel = txtt.getText().trim();
			int point = 1000;
			try {
				point = Integer.parseInt(txtp.getText());
			} catch (Exception e1) {
				System.out.println("1" + e1.getMessage());
			}
			if (name != null && tel != null && point >= 0) {
				hm.put(tel, new Customer(tel, name, point));
				txta.append("[이름] : " + name + "\t[폰번호] : " + tel + "\t[포인트] : " + point + "\r\n");
				txtt.setText("");
				txtn.setText("");
				txtp.setText("");
			} else {
				System.out.println("제대로 입력하세요");
				return;
			}
		} else if (e.getSource() == btnt) {

			Iterator<String> iterator = hm.keySet().iterator();
			int cnt = 0;
			String t = txtt.getText();
			while (iterator.hasNext()) {
				String tel = iterator.next();
				String p = null;
				try {
					p = Integer.toString(hm.get(tel).getPoint());
				} catch (Exception e3) {
					System.out.println(e3.getMessage());
				}
				if (t.equals(tel.substring(tel.lastIndexOf("-") + 1))) {
					txtt.setText(hm.get(tel).getTel().toString());
					txtn.setText(hm.get(tel).getName().toString());
					txtp.setText(p.toString());
					//txtp.setText(String.valueOf(hm.get(tel).getPoint()));
					// String.valueOf 사용해서 int값 출력가능.
					break;
				} else {
					cnt++;
				}
			}
			if (cnt == hm.size()) {
				txtt.setText("찾는 번호가 없습니다. 다시 시도해 주세요.");
				txtn.setText("");
				txtp.setText("");
			}

		} else if (e.getSource() == btno)

		{
			Writer wt = null;
			try {
				wt = new FileWriter("icon/Customer.txt", true);
				Iterator<String> it = hm.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					String str = hm.get(key).toString();
					wt.write(str);
				}
			} catch (IOException e2) {
				System.out.println("2" + e2.getMessage());
			} finally {
				try {
					wt.close();
				} catch (Exception e3) {
				}
			}

		} else if (e.getSource() == btne) {
			setVisible(false);
			dispose();
			System.exit(0);

		}

	}

	public static void main(String[] args) {
		new Homework("회원관리");
	}

}
