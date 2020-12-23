package com.lec.ex09_book;

public class Book implements ILendable {
	private String bno; //å û����ȣ
	private String bt;  //å ����
	private String wt;  //����
	private String bn;  //������ (�Է�)
	private String cod; //������ (�Է�)
	private byte st; //���� ����
	public Book() {}
	public Book(String bno,String bt,String wt) {
		this.bno=bno;
		this.bt=bt;
		this.wt=wt;
	}
	@Override
	public void cOut(String bn, String cod) {
		if(st!=STATE_NOMAL) {
			System.out.println("���� ��. ����Ұ�.");
			return;
		}
		//����ó������	
		this.bn=bn;
		this.cod=cod;
		st=STATE_BORROWED;
		System.out.println("\""+bt+"\"������ ����Ǿ����ϴ�");
	}

	@Override
	public void cIn() {
		if(st!=STATE_BORROWED) {
			System.out.println("������°� �ƴ�. Ȯ�ιٶ�.");
			return;
		}
		//�ݳ�ó������
		bn=null;
		cod=null;
		st=STATE_NOMAL;
		System.out.println("\""+bt+"\"������ �ݳ��Ǿ����ϴ�.");
	}

	@Override
	public void pstate() {
		if(st==STATE_NOMAL) {
			System.out.printf("%s, %s�� - ���Ⱑ��\n",bt,wt);
		}else if(st==STATE_BORROWED) {
			System.out.printf("%s, %s�� - ������\n",bt,wt);
		}else {
			System.out.println("����");
		}
		//���׿�����
//		String msg = bt+","+wt+" - ";
//		msg+= st==STATE_NOMAL? "���Ⱑ��":"������";
//		System.out.println(msg);
	}
	
}
