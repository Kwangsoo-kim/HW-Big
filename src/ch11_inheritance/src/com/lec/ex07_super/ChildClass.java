package com.lec.ex07_super;

public class ChildClass extends ParentClass{
	private String cStr = "�ڽ� Ŭ����";
	public ChildClass() {
		System.out.println("�ڽ� ������");
	}
	@Override
	public void getMaminame() {
		//super. : �θ�Ŭ�������� ������� ��ü��            **��ġ�� ������ ����
		//super() : �θ�Ŭ������ ������                       **�ݵ�� �� �� �ٿ��� �����.
		System.out.print("�̻� ���� �̻� ");
		super.getMaminame();
	}
	public String getcStr() {
		return cStr;
	}
	public void setcStr(String cStr) {
		this.cStr = cStr;
	}

}
