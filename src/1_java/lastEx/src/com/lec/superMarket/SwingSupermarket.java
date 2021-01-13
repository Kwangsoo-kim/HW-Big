package com.lec.superMarket;

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

public class SwingSupermarket extends JFrame implements ActionListener {
	private Container container;
	private JPanel jpup;
	private JPanel jpbtn;
	private JTextField txtCId;
	private JTextField txtCTel;
	private JTextField txtCName;
	private JTextField txtCPoint;
	private JTextField txtCAmount;
	private Vector<String> lnames;
	private JComboBox<String> comLevelName;
	private JButton btnCIdSearch;
	private JButton btnCTelSearch;
	private JButton btnCNameSearch;
	private JButton btnBuyWithPoint;
	private JButton btnBuy;
	private JButton btnLevelNameOutput;
	private JButton btnAllOutput;
	private JButton btnInsert;
	private JButton btnCTelUpdate;
	private JButton btnDelete;
	private JButton btnExit;
	private JTextArea txtPool;
	private JScrollPane JScrollPane;
	CustomerDao dao = CustomerDao.getInstance();
	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();

	public SwingSupermarket(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtCId = new JTextField(15);
		txtCTel = new JTextField(15);
		txtCName = new JTextField(15);
		txtCPoint = new JTextField(15);
		txtCAmount = new JTextField(15);
		lnames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(lnames);
		btnCIdSearch = new JButton("아이디검색");
		btnCTelSearch = new JButton("폰4자리(FULL)검색");
		btnCNameSearch = new JButton("고객 이름 검색");
		btnBuyWithPoint = new JButton("포인트로만 구매");
		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCTelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		txtPool = new JTextArea(6, 70);
		JScrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("아이디", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("고객전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("고객이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(JScrollPane);
		setVisible(true);
		setSize(new Dimension(800, 400));
		setLocation(200, 150);
		btnCIdSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCNameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCIdSearch) {
			// CIDSearch-----------------------------------------------CIDSearch
			String cid = txtCId.getText().trim();
			if (cid.equals("")) {
				txtPool.setText("유효한 고객ID를 입력하시고 아이디를 검색하세요");
				return;
			} else {
				dtos = dao.cidgetCustomer(cid);
				if (dtos.isEmpty()) {
					txtPool.setText("검색되지 않는 ID입니다");
					txtCId.setText("");
				} else if (dtos.size() == 1) {
					txtCId.setText(dtos.get(0).getCid());
					txtCTel.setText(dtos.get(0).getCtel());
					txtCName.setText(dtos.get(0).getCname());
					txtCPoint.setText(Integer.toString(dtos.get(0).getCpoint()));
					comLevelName.setSelectedItem(dtos.get(0).getLname());
					txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음등급까지 남은 구매금액\n"
							+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					for (CustomerDto d : dtos) {
						txtPool.append(d.toString());
					}
				}
			}
			// CIDSearch-----------------------------------------------CIDSearch
		} else if (e.getSource() == btnCTelSearch) {
			// CtelSearch-----------------------------------------------CtelSearch
			String ctel = txtCTel.getText().trim();
			if (ctel.equals("")) {
				txtPool.setText("전화번호 뒷자리4개 혹은 전화번호 전체를 입력해주세요");
				return;
			} else {
				dtos = dao.cTelGetCustomers(ctel);
				if (dtos.isEmpty()) {
					txtPool.setText("검색되지 않는 전화번호 입니다.");
					txtCTel.setText("");
				} else if (dtos.size() > 0) {
					txtCId.setText(dtos.get(dtos.size() - 1).getCid());
					txtCTel.setText(dtos.get(dtos.size() - 1).getCtel());
					txtCName.setText(dtos.get(dtos.size() - 1).getCname());
					txtCPoint.setText(Integer.toString(dtos.get(dtos.size() - 1).getCpoint()));
					comLevelName.setSelectedItem(dtos.get(dtos.size()-1).getLname());
					txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음등급까지 남은 구매금액\n"
							+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					for (CustomerDto d : dtos) {
						txtPool.append(d.toString() + "\n");
					}

				}
			}
			// CtelSearch-----------------------------------------------CtelSearch
		} else if (e.getSource() == btnCNameSearch) {
			// CnameSearch-----------------------------------------------CnameSearch
			String cname = txtCName.getText().trim();
			if (cname.equals("")) {
				txtPool.setText("고객이름을 입력해 주세요");
				return;
			} else {
				dtos = dao.cNameGetCustomers(cname);
				if (dtos.isEmpty()) {
					txtPool.setText("해당 이름의 고객이 검색되지 않습니다. 회원가입을 해주세요");
					txtCTel.setText("");
				} else if (dtos.size() > 0) {
					txtCId.setText(dtos.get(dtos.size() - 1).getCid());
					txtCTel.setText(dtos.get(dtos.size() - 1).getCtel());
					txtCName.setText(dtos.get(dtos.size() - 1).getCname());
					txtCPoint.setText(Integer.toString(dtos.get(dtos.size() - 1).getCpoint()));
					comLevelName.setSelectedItem(dtos.get(dtos.size() - 1).getLname());
					txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음등급까지 남은 구매금액\n"
							+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					for (CustomerDto d : dtos) {
						txtPool.append(d.toString() + "\n");
					}

				}
			}
			// CnameSearch-----------------------------------------------CnameSearch
		} else if (e.getSource() == btnBuyWithPoint) {
			// buypoint-----------------------------------------------buypoint
			String camountstr = txtCAmount.getText().trim();
			String cpointstr = txtCPoint.getText().trim();
			String cid = txtCId.getText().trim();
			if (camountstr.equals("") || cid.equals("")) {
				txtPool.setText("구매금액 혹은 ID를 입력해주세요");
				return;
			}
			int camount = Integer.parseInt(camountstr);
			int cpoint = Integer.parseInt(cpointstr);
			if (cpoint >= camount) {
				int result = dao.buyWithPoint(camount, cid);
				if(result==CustomerDao.SUCCESS) {
				txtPool.setText("포인트로만 결제완료");
				txtCAmount.setText("");
				}else {
					System.out.println("입력실패");
				}
			} else {
				txtPool.setText("포인트가 부족하여 포인트로 구매 불가능합니다");
				txtCAmount.setText("");
			}
			// buypoint-----------------------------------------------buypoint
		} else if (e.getSource() == btnBuy) {
			// buy-----------------------------------------------buy
			String camountstr = txtCAmount.getText().trim();
			String cid = txtCId.getText().trim();
			if (camountstr.equals("") || cid.equals("")) {
				txtPool.setText("구매금액과 ID를 입력해주세요");
				return;
			}
			int camount = Integer.parseInt(camountstr);
			int result = dao.buy(camount, cid);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("물품구매 및 레벨 조정 성공");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
			}
			// buy-----------------------------------------------buy
		} else if (e.getSource() == btnLevelNameOutput) {
			// lnameSearch-----------------------------------------------lnameSearh
			String lname = comLevelName.getSelectedItem().toString();
			dtos = dao.levelNameGetCustomers(lname);
			if (dtos.isEmpty()) {
				txtPool.setText("해당 등급의 고객이 없습니다.");
			} else if (dtos.size() > 0) {
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음등급까지 남은 구매금액\n"
						+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				for (CustomerDto d : dtos) {
					txtPool.append(d.toString() + "\n");
				}
				txtPool.append("총 " + dtos.size() + "명");
			}
			// lnameSearch-----------------------------------------------lnameSearh
		} else if (e.getSource() == btnAllOutput) {
			// allout-----------------------------------------------allout
			dtos = dao.selectAll();
			if (dtos.isEmpty()) {
				txtPool.setText("가입된 고객이 없습니다.");
				txtCTel.setText("");
			} else if (dtos.size() > 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음등급까지 남은 구매금액\n"
						+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				for (CustomerDto d : dtos) {
					txtPool.append(d.toString() + "\n");
				}
				txtPool.append("총 " + dtos.size() + "명");

			}
			// allout-----------------------------------------------allout
		} else if (e.getSource() == btnInsert) {
			// insert-----------------------------------------------insert
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();
			if (ctel.equals("") || cname.equals("")) {
				txtPool.setText("고객번호,이름 모두 입력하세요");
			}
			CustomerDto dto = new CustomerDto(ctel, cname);
			int result = dao.insertCustomer(dto);
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText(cname + "님 고객 입력 성공");
				txtCTel.setText("");
				txtCName.setText("");
			} else {
				System.out.println("입력실패");
			}
			// insert-----------------------------------------------insert
		} else if (e.getSource() == btnCTelUpdate) {
			// telup-----------------------------------------------telup
			String ctel = txtCTel.getText().trim();
			String cid = txtCId.getText().trim();
			if (ctel.equals("") || cid.equals("")) {
				txtPool.setText("유효한 고객ID를 검색 후 번호변경을 하세요");
			}
			int result = dao.updateCustomerTel(ctel, cid);
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText("전화번호 업데이트 성공");
				txtCId.setText("");
				comLevelName.setSelectedIndex(0);
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				comLevelName.setSelectedIndex(0);
			} else {
				System.out.println("입력실패");
			}
			// telup-----------------------------------------------telup
		} else if (e.getSource() == btnDelete) {
			// delete-----------------------------------------------delete
			String cid = txtCId.getText().trim();
			if (cid.equals("")) {
				txtPool.setText("삭제할 ID를 입력해 주세요");
			}
			int result = dao.deleteCustomer(cid);
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText("아이디 : " + cid + " - 삭제 완료");
				txtCId.setText("");
			} else {
				System.out.println("입력실패");
			}
			// delete-----------------------------------------------delete
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new SwingSupermarket("슈퍼마켓 관리");
	}
}
