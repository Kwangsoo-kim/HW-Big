package com.lec.ex0_janmuri;

class PersonInfo {
	private String name;
	private int age;
	private char gender; // ���� '��', '��'

	public PersonInfo() {
	}// ������ ������� ����Ʈ�����ڴ� �ڵ�����

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}// ������ �����ε�

	public void print() {
		System.out.println("�̸� = " + name + "  ���� = " + age + "\t ���� = " + gender);
	}

	public String infoString() {
		String result = "�̸� = " + name + "  ���� = " + age + "\t ���� = " + gender;
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}
}

public class PersonInfoTestMain {
	public static void main(String[] args) {
		int[] iArr = {10,20,30};
		int[] jArr;
		PersonInfo[] person = { 
				new PersonInfo("ȫ�浿",20,'��'), new PersonInfo("ȫ���",22,'��'), new PersonInfo()
		};
		person[2].setName("ȫ���");
		person[2].setAge(30);
		person[2].setGender('��');
//		for(int i=0;i<person.length;i++ ) {
//			System.out.println(person[i].infoString());
//		}
		for(PersonInfo p : person) {
			p.print();
		}
		

	}
}
