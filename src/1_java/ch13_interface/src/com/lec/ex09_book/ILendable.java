package com.lec.ex09_book;

public interface ILendable {
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NOMAL = 0; // ���Ⱑ��
	public void cOut(String bn,String cd); //�������
	public void cIn(); //�ݳ�����
	public void pstate(); // å ����. "å�̸�" , "����", "���Ⱑ������"
}
