//201221 kks gui_awt
package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex05_Frame extends Frame implements ActionListener {
	private Panel p1;
	private TextField txtwt;
	private Button btnok;
	private Button btnexit;
	private List lt;
	public Ex05_Frame() {
		//layout ��Ƽ�� ������Ʈ ���� �� add, setvisible, setsize
		setLayout(new BorderLayout());
		p1 = new Panel(new FlowLayout());  //panel�� flowlayout�� �⺻
		txtwt = new TextField(20);
		btnok = new Button("OK");
		btnexit = new Button("EXIT");
		lt = new List(); //������ ������ ��ŭ ������.
		p1.add(new Label("write"));
		p1.add(txtwt);
		p1.add(btnok);
		p1.add(btnexit);
		add(p1,BorderLayout.NORTH);
		add(lt,BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400,200 ));
		setLocation(200,200);
		// 1. implements ActionListener
		// 2. �̺�Ʈ ������ �߰�
		// 3. ���� �߰�
		btnok.addActionListener(this);  //�ڵ����� this.actionperformed(btnok) �Է�
		btnexit.addActionListener(this);//�ڵ����� this.actionperformed(btnexit) �Է�
	}
	public Ex05_Frame(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnok) {
			//txtField�� �ؽ�Ʈ�� list�� �߰��ϰ� txtfield�� ""
			lt.add(txtwt.getText());
			txtwt.setText("");
		}else if(e.getSource() == btnexit){
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex05_Frame();
	}
}
