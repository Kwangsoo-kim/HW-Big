//210108 kks lastex2_mnggui
package com.lec.person_dao;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGui extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup;
	private JPanel jpbt;
	private JTextField txtName;
	private JTextField txtkor;
	private JTextField txteng;
	private JTextField txtmat;
	private Vector<String> jnames;
	private JComboBox<String> comjob;
	private JButton btnInput;
	private JButton btnSearch;
	private JButton btnOutput;
	private JButton btnExit;
	private ImageIcon icon_write;
	private ImageIcon icon_hot;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	PersonDao dao = PersonDao.getInsetance();
	ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
	
	public PersonMngGui(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5,2));
		jpbt = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comjob = new JComboBox<String>(jnames);
		txtkor = new JTextField(20);
		txteng = new JTextField(20);
		txtmat = new JTextField(20);
		icon_write = new ImageIcon("icon/write.gif");
		btnInput = new JButton("�Է�",icon_write);
		icon_hot = new ImageIcon("icon/hot.gif");
		btnSearch = new JButton("������ȸ",icon_hot);
		btnOutput = new JButton("��ü���");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10,60);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�̸�",(int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����",(int) CENTER_ALIGNMENT));
		jpup.add(comjob);
		jpup.add(new JLabel("����",(int) CENTER_ALIGNMENT));
		jpup.add(txtkor);
		jpup.add(new JLabel("����",(int) CENTER_ALIGNMENT));
		jpup.add(txteng);
		jpup.add(new JLabel("����",(int) CENTER_ALIGNMENT));
		jpup.add(txtmat);
		jpbt.add(btnInput);
		jpbt.add(btnSearch);
		jpbt.add(btnOutput);
		jpbt.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbt);
		contenPane.add(scrollPane);
		setVisible(true);
		setSize(new Dimension(700,450));
		setLocation(200,150);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnInput) {	//�̸�, ������, ������ �ٴ�ͼ� dao.insert ȣ��
			String pname = txtName.getText().trim();
			String jname = comjob.getSelectedItem().toString();
			String korstr = txtkor.getText().trim();
			String engstr = txteng.getText().trim();
			String matstr = txtmat.getText().trim();
			if(pname.equals("")||jname.equals("")||korstr.equals("")||engstr.equals("")||matstr.equals("")) {
				txtPool.setText("��ĭ ���� �Է��Ͻÿ�");
			}
			int kor = Integer.parseInt(korstr);
			int eng = Integer.parseInt(engstr);
			int mat = Integer.parseInt(matstr);
			PersonDto dto = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(dto);
			if(result==PersonDao.SUCCESS) {
				txtPool.setText(pname+"�Է¼���");
				txtName.setText("");
				comjob.setSelectedIndex(0);
				txtkor.setText("");
				txteng.setText("");
				txtmat.setText("");
			}else {
				System.out.println("�Է½���");
			}
		}else if(e.getSource()==btnSearch) {	// ���������� dao.selectJanme ȣ��
			String jname = comjob.getSelectedItem().toString();			
			if(jname.equals("")) {
				txtPool.setText("������ �����ϼ���");
				return;
			}else {
				dtos = dao.selectJname(jname);
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
				if(dtos.isEmpty()) {
					txtPool.setText(txtPool.getText()+"�ش� ������ �ο��� �����ϴ�.");
				}
				for(PersonDto d : dtos) {
					txtPool.append(d.toString()+"\n");
				}
			}
			
		}else if(e.getSource()==btnOutput) {	// dao.selectAll ȣ��
			dtos = dao.selectAll();
			txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
			if(dtos.isEmpty()) {
				txtPool.setText(txtPool.getText()+"�ش� ������ �ο��� �����ϴ�.");
			}
			for(PersonDto d : dtos) {
				txtPool.append(d.toString()+"\n");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
		
	public static void main(String[] args) {
		new PersonMngGui("������ ���� ����");
	}
	
}
