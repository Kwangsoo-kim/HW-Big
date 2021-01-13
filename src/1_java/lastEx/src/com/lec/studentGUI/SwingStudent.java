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
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
				txtPool.setText("학번을 입력하세요");
				return;
			} else {
				dtos = dao.selectSno(sno);
				if (dtos.isEmpty()) {
					txtPool.setText(txtPool.getText() + txtSNo.getText() + " 학번은 존재하지 않습니다.");
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
				txtPool.setText("이름을 입력하세요");
				return;
			} else {
				dtos = dao.selectSname(sname);
				if (dtos.isEmpty()) {
					txtPool.setText(txtPool.getText() + "해당 이름의 학생이 없습니다.");
				} else if (dtos.size() == 1) {
					txtSNo.setText(dtos.get(0).getSno());
					txtSName.setText(dtos.get(0).getSname());
					comMname.setSelectedItem(dtos.get(0).getMname());
					txtScore.setText(Integer.toString(dtos.get(0).getScore()));
				} else if (dtos.size() > 1) {
					txtPool.setText("학번\t이름\t학과명\t점수\n");
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
				txtPool.setText("학과를 선택하세요");
				return;
			} else {
				dtos = dao.selectMname(mname);
				txtPool.setText("등수\t이름(sNO)\t\t학과\t점수\n");
				if (dtos.isEmpty()) {
					txtPool.setText(txtPool.getText() + "해당 학과에 인원이 없습니다.");
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
				txtPool.setText(" 빈칸 없이 입력하세요");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto dto = new StudentSwingDto(sname, mname, score);
			int result = dao.insertStudent(dto);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sname + "학생입력성공");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtSNo.setText("");
			} else {
				System.out.println("입력실패");
			}
		} else if (e.getSource() == btnUpdate) {
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String scorestr = txtScore.getText().trim();
			String snostr = txtSNo.getText().trim();
			if (sname.equals("") || mname.equals("") || scorestr.equals("") || snostr.equals("")) {
				txtPool.setText(" 빈칸 없이 입력하세요");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto dto = new StudentSwingDto(snostr, sname, mname, score);
			int result = dao.updateStudent(dto);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sname + "업데이트 성공");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} else {
				System.out.println("입력실패");
			}
		} else if (e.getSource() == btnStudentOut) {
			dtos = dao.selectAllnoEX();
			txtPool.setText("등수\t이름(sNO)\t\t학과\t점수\n");
			if (dtos.isEmpty()) {
				txtPool.setText(txtPool.getText() + "학생이 없습니다.");
			}
			for (StudentSwingDto d : dtos) {
				txtPool.append(d.toString() + "\n");
			}
		} else if (e.getSource() == btnExpelOut) {
			dtos = dao.selectAllEx();
			txtPool.setText("등수\t이름(sNO)\t\t학과\t점수\n");
			if (dtos.isEmpty()) {
				txtPool.setText(txtPool.getText() + "재적 학생이 없습니다.");
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
				txtPool.setText(" 빈칸 없이 입력하세요");
			}
			int sno = Integer.parseInt(snostr);
			int result = dao.updateExpel(Integer.toString(sno));
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sname + "업데이트 성공");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtSNo.setText("");
			} else {
				System.out.println("입력실패");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SwingStudent("학사관리");

	}
}