package com.lec.ex;
// Car myPorsche = new Car();
// Į�� �ٲٱ� myPorsche.color = "red";
public class Car { 
	//������
	private String color; //class���� �Ϲ������� ������(private), �޼ҵ�(public) 
	private int cc;
	private int speed;
	
	public Car() {
		// ������ �Լ� = ����Ÿ���� ���� Ŭ������� ���� �̸��� �޼ҵ� . Ŭ���� ���� �����Ϳ� �޼ҵ� ���̿� �ڵ����� �����
		// ����Ʈ �������Լ��� ������ �Լ��� ���� �� JVM�� �ڵ�����.
		// ��ü������ ������ �� �ڵ� ȣ��
		cc=1000; 
		
	}
	
	//�޼ҵ�
	public void drive() {
		speed = 60;
		System.out.println("�����Ѵ� ���� �ӵ� : "+ speed);
	}
	void park() { //public �Ⱦ��� public �Ⱦ��Ͱ� ����. ����Ʈ ����?
		speed = 0;
		System.out.println("�����Ѵ� ���� �ӵ� : "+ speed);
	}
	void race() {
		speed = 120;
		System.out.println("���̽� �Ѵ� ���� �ӵ� :"+ speed);
	}
	//private�� ������ color, cc, speed�� �������ų�(get) ������(set) �޼ҵ带 �������Ѵ�.
	//set�޼ҵ� ex)~.set~()
	public void setColor(String color) {
		this.color = color;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	//get�޼ҵ� ex)~.get~()
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
}
//class�� ���� : 1.������ 2.������ �Լ� 3.�޼ҵ� 4.set�Լ�5.get �Լ�