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
	private Label lbl1; // 추가할 컴포넌트 변수들 선언
	private Button btnExit;

	public Ex02_MyFrame() {
		// 프레임에 라벨과 버튼 추가후 setVisible과 setSize
		setLayout(new FlowLayout()); // 프레임의 layout 스타일을 flowLayout()으로 - add순서대로 차곡차곡배열
		// setLayout(new BorderLayout()); - 기본 Layout
		// setLayout(new GridLayout(2,2)); - 2행 2열짜리 격자 Layout
		lbl1 = new Label("즐거운 월요일");
		lbl1.setPreferredSize(new Dimension(150, 200)); // 컴포넌트 사이즈
		btnExit = new Button("종료");
		btnExit.setPreferredSize(new Dimension(200, 200));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500, 300));
		setLocation(100, 100);
		btnExit.addActionListener(this); //** btnExit 클릭이벤트가 발생하면 this.actionperfomed(btnExit)호출
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
	public void actionPerformed(ActionEvent e) { // 이벤트 처리 메소드
		// btnExit 클릭이벤트가 발생하면 this.actionperfomed(btnExit)호출
		if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex02_MyFrame("두 번째 GUI 예제");
	}
}
