package com.lec.ex04_actor;
//����implements(������) �� �̿��� ������
public class TestMain {
	public static void main(String[] args) {
		Actor p = new Actor("�ں���"); //����implements�� Ÿ���̱� ������ ���� interface��밡��.
		p.ccc();
		p.cci();
		p.offf();
		p.sm();
		p.ms();
		p.mp();
		Ifirefighter fp = p;  //Ÿ���� firefighterŸ���̶� �ٸ� Ÿ���� �޼ҵ�� ����� �� ����.
		fp.offf();
		fp.sm();
		Ipolice pp =p;  //Ÿ���� policeŸ���̶� �ٸ� Ÿ���� �޼ҵ�� ����� �� ����.
		pp.ccc();
		pp.cci();
		Ichef cp=p; //Ÿ���� chefŸ���̶� �ٸ� Ÿ���� �޼ҵ�� ����� �� ����.
		cp.mp();
		cp.ms();
	}
}
