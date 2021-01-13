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
		btnCIdSearch = new JButton("���̵�˻�");
		btnCTelSearch = new JButton("��4�ڸ�(FULL)�˻�");
		btnCNameSearch = new JButton("�� �̸� �˻�");
		btnBuyWithPoint = new JButton("����Ʈ�θ� ����");
		btnBuy = new JButton("��ǰ ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCTelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");
		txtPool = new JTextArea(6, 70);
		JScrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("���̵�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
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
				txtPool.setText("��ȿ�� ��ID�� �Է��Ͻð� ���̵� �˻��ϼ���");
				return;
			} else {
				dtos = dao.cidgetCustomer(cid);
				if (dtos.isEmpty()) {
					txtPool.setText("�˻����� �ʴ� ID�Դϴ�");
					txtCId.setText("");
				} else if (dtos.size() == 1) {
					txtCId.setText(dtos.get(0).getCid());
					txtCTel.setText(dtos.get(0).getCtel());
					txtCName.setText(dtos.get(0).getCname());
					txtCPoint.setText(Integer.toString(dtos.get(0).getCpoint()));
					comLevelName.setSelectedItem(dtos.get(0).getLname());
					txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������ޱ��� ���� ���űݾ�\n"
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
				txtPool.setText("��ȭ��ȣ ���ڸ�4�� Ȥ�� ��ȭ��ȣ ��ü�� �Է����ּ���");
				return;
			} else {
				dtos = dao.cTelGetCustomers(ctel);
				if (dtos.isEmpty()) {
					txtPool.setText("�˻����� �ʴ� ��ȭ��ȣ �Դϴ�.");
					txtCTel.setText("");
				} else if (dtos.size() > 0) {
					txtCId.setText(dtos.get(dtos.size() - 1).getCid());
					txtCTel.setText(dtos.get(dtos.size() - 1).getCtel());
					txtCName.setText(dtos.get(dtos.size() - 1).getCname());
					txtCPoint.setText(Integer.toString(dtos.get(dtos.size() - 1).getCpoint()));
					comLevelName.setSelectedItem(dtos.get(dtos.size()-1).getLname());
					txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������ޱ��� ���� ���űݾ�\n"
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
				txtPool.setText("���̸��� �Է��� �ּ���");
				return;
			} else {
				dtos = dao.cNameGetCustomers(cname);
				if (dtos.isEmpty()) {
					txtPool.setText("�ش� �̸��� ���� �˻����� �ʽ��ϴ�. ȸ�������� ���ּ���");
					txtCTel.setText("");
				} else if (dtos.size() > 0) {
					txtCId.setText(dtos.get(dtos.size() - 1).getCid());
					txtCTel.setText(dtos.get(dtos.size() - 1).getCtel());
					txtCName.setText(dtos.get(dtos.size() - 1).getCname());
					txtCPoint.setText(Integer.toString(dtos.get(dtos.size() - 1).getCpoint()));
					comLevelName.setSelectedItem(dtos.get(dtos.size() - 1).getLname());
					txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������ޱ��� ���� ���űݾ�\n"
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
				txtPool.setText("���űݾ� Ȥ�� ID�� �Է����ּ���");
				return;
			}
			int camount = Integer.parseInt(camountstr);
			int cpoint = Integer.parseInt(cpointstr);
			if (cpoint >= camount) {
				int result = dao.buyWithPoint(camount, cid);
				if(result==CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ�θ� �����Ϸ�");
				txtCAmount.setText("");
				}else {
					System.out.println("�Է½���");
				}
			} else {
				txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���� �Ұ����մϴ�");
				txtCAmount.setText("");
			}
			// buypoint-----------------------------------------------buypoint
		} else if (e.getSource() == btnBuy) {
			// buy-----------------------------------------------buy
			String camountstr = txtCAmount.getText().trim();
			String cid = txtCId.getText().trim();
			if (camountstr.equals("") || cid.equals("")) {
				txtPool.setText("���űݾװ� ID�� �Է����ּ���");
				return;
			}
			int camount = Integer.parseInt(camountstr);
			int result = dao.buy(camount, cid);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ǰ���� �� ���� ���� ����");
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
				txtPool.setText("�ش� ����� ���� �����ϴ�.");
			} else if (dtos.size() > 0) {
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������ޱ��� ���� ���űݾ�\n"
						+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				for (CustomerDto d : dtos) {
					txtPool.append(d.toString() + "\n");
				}
				txtPool.append("�� " + dtos.size() + "��");
			}
			// lnameSearch-----------------------------------------------lnameSearh
		} else if (e.getSource() == btnAllOutput) {
			// allout-----------------------------------------------allout
			dtos = dao.selectAll();
			if (dtos.isEmpty()) {
				txtPool.setText("���Ե� ���� �����ϴ�.");
				txtCTel.setText("");
			} else if (dtos.size() > 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������ޱ��� ���� ���űݾ�\n"
						+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				for (CustomerDto d : dtos) {
					txtPool.append(d.toString() + "\n");
				}
				txtPool.append("�� " + dtos.size() + "��");

			}
			// allout-----------------------------------------------allout
		} else if (e.getSource() == btnInsert) {
			// insert-----------------------------------------------insert
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();
			if (ctel.equals("") || cname.equals("")) {
				txtPool.setText("����ȣ,�̸� ��� �Է��ϼ���");
			}
			CustomerDto dto = new CustomerDto(ctel, cname);
			int result = dao.insertCustomer(dto);
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText(cname + "�� �� �Է� ����");
				txtCTel.setText("");
				txtCName.setText("");
			} else {
				System.out.println("�Է½���");
			}
			// insert-----------------------------------------------insert
		} else if (e.getSource() == btnCTelUpdate) {
			// telup-----------------------------------------------telup
			String ctel = txtCTel.getText().trim();
			String cid = txtCId.getText().trim();
			if (ctel.equals("") || cid.equals("")) {
				txtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ������ �ϼ���");
			}
			int result = dao.updateCustomerTel(ctel, cid);
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText("��ȭ��ȣ ������Ʈ ����");
				txtCId.setText("");
				comLevelName.setSelectedIndex(0);
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				comLevelName.setSelectedIndex(0);
			} else {
				System.out.println("�Է½���");
			}
			// telup-----------------------------------------------telup
		} else if (e.getSource() == btnDelete) {
			// delete-----------------------------------------------delete
			String cid = txtCId.getText().trim();
			if (cid.equals("")) {
				txtPool.setText("������ ID�� �Է��� �ּ���");
			}
			int result = dao.deleteCustomer(cid);
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText("���̵� : " + cid + " - ���� �Ϸ�");
				txtCId.setText("");
			} else {
				System.out.println("�Է½���");
			}
			// delete-----------------------------------------------delete
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new SwingSupermarket("���۸��� ����");
	}
}
