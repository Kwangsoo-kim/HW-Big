package com.lec.ex09_person;
//Baby p = new Baby("ȫ�浿","���ϴ�")
public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű� ���� ���� Baby ��ü ����");
	}
	public Baby(String na,String cha) {
		super(na,cha); // �θ�� ������. �Ű����� �ִ³����� ȣ��ǰ�.   **�׻� ù ��ɾ�� ȣ��Ǿ����.
		System.out.println("�Űܺ��� �ִ� Baby ��ü ����");
	}
	public void Cry() {
		System.out.println("��������");
	}
	@Override
	public void intro() {
		System.out.println(getNa()+"��(��) �Ʊ�� ������ ��� �Ұ��Ҳ�");
		super.intro();
	}
}
