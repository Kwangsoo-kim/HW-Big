//201221 kks gui_swing
package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02_Frame extends JFrame implements ActionListener {
	// private JPanel p1; //�����̳� ���ͼ� ���� ����
	private Container con; // �����̳� ���ͼ� ���� ����
	private JLabel lbl;
	private ImageIcon icon;
	private JButton btn;
	private JTextField txtf;
	private Vector<String> item; // �޺��ڽ� ���빰
	private JComboBox<String> combo;
	private JCheckBox cbox;
	private JLabel lblb;
	private JButton btnexit;

	public Ex02_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x������ ������ ��ư
		con = getContentPane(); // �����̳� ������
		// p1 = (JPanel)getContentPane() �����̳� ������. ���� �ƹ��ų� �ص� ����.
		con.setLayout(new FlowLayout()); // layout ����
		lbl = new JLabel("Label");
		icon = new ImageIcon("icon/write.gif");
		btn = new JButton("Button", icon);
		txtf = new JTextField(20);
		item = new Vector<String>();
		item.add("A");
		item.add("B");
		item.add("C");
		combo = new JComboBox<String>(item);
		cbox = new JCheckBox("CheckBox");
		lblb = new JLabel();
		btnexit = new JButton("Exit");
		lbl.setPreferredSize(new Dimension(50, 50));
		btn.setPreferredSize(new Dimension(200, 50));
		txtf.setPreferredSize(new Dimension(300, 50));
		cbox.setPreferredSize(new Dimension(100, 50));
		combo.setPreferredSize(new Dimension(100, 50));
		lblb.setPreferredSize(new Dimension(200, 50));
		btnexit.setPreferredSize(new Dimension(100, 50));
		con.add(lbl);
		con.add(btn);
		con.add(txtf);
		con.add(combo);
		con.add(cbox);
		con.add(lblb);
		con.add(btnexit);
		setVisible(true);
		pack();
		setLocation(200, 200);
		btn.addActionListener(this);
		combo.addActionListener(this);
		cbox.addActionListener(this);
		btnexit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			String temp = txtf.getText().trim();
			if(!temp.equals("")) {
				lblb.setText(temp);
				combo.addItem(temp); //�޺��ڿ��� �߰��Ǹ� item���� �߰��ȴ�.
				txtf.setText("");
				String name = JOptionPane.showInputDialog("�̸���?");
				if(name!=null) {
					cbox.setText(name);
				}else if(temp.equals("")) return;
			}
		}else if(e.getSource() == combo) {
			lblb.setText(combo.getSelectedItem().toString());
			
		}else if(e.getSource() == cbox) {
			if(cbox.isSelected()) { //üũ�ڽ� üũ ����
				lblb.setText(cbox.getText());
			}else {
				System.out.println("üũ�ڽ��� ��üũ��");
			}
		}else if(e.getSource() == btnexit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}
	public static void main(String[] args) {
		new Ex02_Frame("");
	}
}
