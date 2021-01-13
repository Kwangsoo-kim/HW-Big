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
		btnInput = new JButton("입력",icon_write);
		icon_hot = new ImageIcon("icon/hot.gif");
		btnSearch = new JButton("직업조회",icon_hot);
		btnOutput = new JButton("전체출력");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10,60);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("이름",(int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업",(int) CENTER_ALIGNMENT));
		jpup.add(comjob);
		jpup.add(new JLabel("국어",(int) CENTER_ALIGNMENT));
		jpup.add(txtkor);
		jpup.add(new JLabel("영어",(int) CENTER_ALIGNMENT));
		jpup.add(txteng);
		jpup.add(new JLabel("수학",(int) CENTER_ALIGNMENT));
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
		if(e.getSource()== btnInput) {	//이름, 직업명, 국영수 바당와서 dao.insert 호출
			String pname = txtName.getText().trim();
			String jname = comjob.getSelectedItem().toString();
			String korstr = txtkor.getText().trim();
			String engstr = txteng.getText().trim();
			String matstr = txtmat.getText().trim();
			if(pname.equals("")||jname.equals("")||korstr.equals("")||engstr.equals("")||matstr.equals("")) {
				txtPool.setText("빈칸 없이 입력하시오");
			}
			int kor = Integer.parseInt(korstr);
			int eng = Integer.parseInt(engstr);
			int mat = Integer.parseInt(matstr);
			PersonDto dto = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(dto);
			if(result==PersonDao.SUCCESS) {
				txtPool.setText(pname+"입력성공");
				txtName.setText("");
				comjob.setSelectedIndex(0);
				txtkor.setText("");
				txteng.setText("");
				txtmat.setText("");
			}else {
				System.out.println("입력실패");
			}
		}else if(e.getSource()==btnSearch) {	// 직업명으로 dao.selectJanme 호출
			String jname = comjob.getSelectedItem().toString();			
			if(jname.equals("")) {
				txtPool.setText("직업을 선택하세요");
				return;
			}else {
				dtos = dao.selectJname(jname);
				txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
				if(dtos.isEmpty()) {
					txtPool.setText(txtPool.getText()+"해당 직업에 인원이 없습니다.");
				}
				for(PersonDto d : dtos) {
					txtPool.append(d.toString()+"\n");
				}
			}
			
		}else if(e.getSource()==btnOutput) {	// dao.selectAll 호출
			dtos = dao.selectAll();
			txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
			if(dtos.isEmpty()) {
				txtPool.setText(txtPool.getText()+"해당 직업에 인원이 없습니다.");
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
		new PersonMngGui("연예인 성적 관리");
	}
	
}
