//201221 kks gui_awt_example
package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SRPgame extends Frame implements ActionListener {
	private Panel p1;
	private Button btnr;
	private Button btns;
	private Button btnp;
	private List lt;
	private Button btnexit;

	public SRPgame() {
		setLayout(new BorderLayout());
		p1 = new Panel();
		btnr = new Button("바위");
		btns = new Button("가위");
		btnp = new Button("보");
		p1.add(btnr);
		p1.add(btns);
		p1.add(btnp);
		lt = new List(5);
		btnexit = new Button("종료");
		add(p1, BorderLayout.NORTH);
		add(lt, BorderLayout.CENTER);
		add(btnexit, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(300, 150));
		setLocation(200, 200);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnr.addActionListener(this);
		btns.addActionListener(this);
		btnp.addActionListener(this);
		btnexit.addActionListener(this);

	}

	public SRPgame(String title) {
		this();
		setTitle(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int com = (int) (Math.random() * 3);
		if (e.getSource() == btnr) {
			int you = 1;
			
			if ((you + 2) % 3 == com) {
				lt.add("내가 이겼다. 너 가위 나 바위");
			} else if (you == com) {
				lt.add("비겼다");
			} else {
				lt.add("내가 졌다. 너 보 나 바위");
			}

		} else if (e.getSource() == btns) {
			int you = 0;
			
			if ((you + 2) % 3 == com) {
				lt.add("내가 이겼다. 너 보 나 가위");
			} else if (you == com) {
				lt.add("비겼다");
			} else {
				lt.add("내가 졌다. 너 바위 나 가위");
			}

		} else if (e.getSource() == btnp) {
			int you = 2;
			
			if ((you + 2) % 3 == com) {
				lt.add("내가 이겼다. 너 바위 나 보");
			} else if (you == com) {
				lt.add("비겼다");
			} else {
				lt.add("내가 졌다. 너 가위 나 보");
			}
		} else if (e.getSource() == btnexit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new SRPgame("첫 게임");
	}

}
