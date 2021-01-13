//210111 kks lastex4_swingmain
package com.lec.studentGUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingStudent extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup;
	private JPanel jpbtn;
	private JTextField txtSNo;
	private JTextField txtSName;
	private Vector<String> mnames;
	private JComboBox<String> comMname;
	private JTextField txtScore;
	private JButton btnSNoSearch;
	private JButton btnSNameSearch;
	private JButton btnMNameSearch;
	private JButton btnInput;
	private JButton btnUpdate;
	private JButton btnStudentOut;
	private JButton btnExpelOut;
	private JButton btnExpel;
	private JButton btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	StudentSwingDao dao = StudentSwingDao.getInstance();
	ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();

	public SwingStudent(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mnames = dao.mnamelist();
		comMname = new JComboBox<String>(mnames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setVisible(true);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNoSearch) {
			String sno = txtSNo.getText().trim();
			if (sno.equals("")) {
				txtPool.setText("�й��� �Է��ϼ���");
				return;
			} else {
				dtos = dao.selectSno(sno);
				if (dtos.isEmpty()) {
					txtPool.setText(txtPool.getText() + txtSNo.getText() + " �й��� �������� �ʽ��ϴ�.");
				} else if (dtos.size() == 1) {
					txtSNo.setText(dtos.get(0).getSno());
					txtSName.setText(dtos.get(0).getSname());
					comMname.setSelectedItem(dtos.get(0).getMname());
					txtScore.setText(Integer.toString(dtos.get(0).getScore()));
				}
			}
		} else if (e.getSource() == btnSNameSearch) {
			String sname = txtSName.getText().trim();
			if (sname.equals("")) {
				txtPool.setText("�̸��� �Է��ϼ���");
				return;
			} else {
				dtos = dao.selectSname(sname);
				if (dtos.isEmpty()) {
					txtPool.setText(txtPool.getText() + "�ش� �̸��� �л��� �����ϴ�.");
				} else if (dtos.size() == 1) {
					txtSNo.setText(dtos.get(0).getSno());
					txtSName.setText(dtos.get(0).getSname());
					comMname.setSelectedItem(dtos.get(0).getMname());
					txtScore.setText(Integer.toString(dtos.get(0).getScore()));
				} else if (dtos.size() > 1) {
					txtPool.setText("�й�\t�̸�\t�а���\t����\n");
					txtSNo.setText(dtos.get(dtos.size() - 1).getSno());
					txtSName.setText(dtos.get(dtos.size() - 1).getSname());
					comMname.setSelectedItem(dtos.get(dtos.size() - 1).getMname());
					txtScore.setText(Integer.toString(dtos.get(dtos.size() - 1).getScore()));
					for (StudentSwingDto d : dtos) {
						txtPool.append(
								d.getSno() + "\t" + d.getSname() + "\t" + d.getMname() + "\t" + d.getScore() + "\t\n");
					}
				}
			}

		} else if (e.getSource() == btnMNameSearch) {
			String mname = comMname.getSelectedItem().toString();
			txtSName.setText("");
			txtScore.setText("");
			txtSNo.setText("");
			if (mname.equals("")) {
				txtPool.setText("�а��� �����ϼ���");
				return;
			} else {
				dtos = dao.selectMname(mname);
				txtPool.setText("���\t�̸�(sNO)\t\t�а�\t����\n");
				if (dtos.isEmpty()) {
					txtPool.setText(txtPool.getText() + "�ش� �а��� �ο��� �����ϴ�.");
				}
				for (StudentSwingDto d : dtos) {
					txtPool.append(d.toString() + "\n");
				}
				
			}
		} else if (e.getSource() == btnInput) {
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String scorestr = txtScore.getText().trim();
			if (sname.equals("") || mname.equals("") || scorestr.equals("")) {
				txtPool.setText(" ��ĭ ���� �Է��ϼ���");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto dto = new StudentSwingDto(sname, mname, score);
			int result = dao.insertStudent(dto);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sname + "�л��Է¼���");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtSNo.setText("");
			} else {
				System.out.println("�Է½���");
			}
		} else if (e.getSource() == btnUpdate) {
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String scorestr = txtScore.getText().trim();
			String snostr = txtSNo.getText().trim();
			if (sname.equals("") || mname.equals("") || scorestr.equals("") || snostr.equals("")) {
				txtPool.setText(" ��ĭ ���� �Է��ϼ���");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto dto = new StudentSwingDto(snostr, sname, mname, score);
			int result = dao.updateStudent(dto);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sname + "������Ʈ ����");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} else {
				System.out.println("�Է½���");
			}
		} else if (e.getSource() == btnStudentOut) {
			dtos = dao.selectAllnoEX();
			txtPool.setText("���\t�̸�(sNO)\t\t�а�\t����\n");
			if (dtos.isEmpty()) {
				txtPool.setText(txtPool.getText() + "�л��� �����ϴ�.");
			}
			for (StudentSwingDto d : dtos) {
				txtPool.append(d.toString() + "\n");
			}
		} else if (e.getSource() == btnExpelOut) {
			dtos = dao.selectAllEx();
			txtPool.setText("���\t�̸�(sNO)\t\t�а�\t����\n");
			if (dtos.isEmpty()) {
				txtPool.setText(txtPool.getText() + "���� �л��� �����ϴ�.");
			}
			for (StudentSwingDto d : dtos) {
				txtPool.append(d.toString() + "\n");
			}

		} else if (e.getSource() == btnExpel) {
			String snostr = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String scorestr = txtScore.getText().trim();
			if (sname.equals("") || mname.equals("") || scorestr.equals("") || snostr.equals("")) {
				txtPool.setText(" ��ĭ ���� �Է��ϼ���");
			}
			int sno = Integer.parseInt(snostr);
			int result = dao.updateExpel(Integer.toString(sno));
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sname + "������Ʈ ����");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtSNo.setText("");
			} else {
				System.out.println("�Է½���");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SwingStudent("�л����");

	}
}