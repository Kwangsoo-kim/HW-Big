package com.lec.ex07_super;

public class ParentClass {
	private String pStr = "�θ�Ŭ����";

	public ParentClass() {
		System.out.println("�θ������");
	}

	public void getPapaname() {
		System.out.println("�ƺ� ȫ�浿");
	}

	public void getMaminame() {
		System.out.println("���� �����");
	}

	public String getpStr() {
		return pStr;
	}

	public void setpStr(String pStr) {
		this.pStr = pStr;
	}

}