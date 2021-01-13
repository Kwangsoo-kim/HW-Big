//210108 kks lastex2_dngdao
package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInsetance();
		ArrayList<PersonDto>dtos = new ArrayList<PersonDto>();
		String fn;
		do {
			System.out.println("1 - INSERT | 2 - ������ ��ȸ | 3 - ��ü ��ȸ | �׿�- ����");
			fn= sc.next();
			switch (fn) {
			case "1" :	// �̸�,������, ������ �Է¹޾� dao.insertPerson() ȣ��
				System.out.println("�Է��� �̸�?");
				String pname = sc.next();
				System.out.println("�Է��� ����?");
				String jname = sc.next();
				System.out.println("�Է��� ��������?");
				int kor = sc.nextInt();
				System.out.println("�Է��� ��������?");
				int eng = sc.nextInt();
				System.out.println("�Է��� ��������?");
				int mat = sc.nextInt();
				PersonDto nperson = new PersonDto(pname, jname, kor, eng, mat);
				int result = dao.insertPerson(nperson);	//�Է³�
				System.out.println(result == PersonDao.SUCCESS? "�Է� ����" : "�Է� ����");
				break;
			case "2" :	// ������ �Է¹޾� dao.selectJname() ȣ���Ͽ� ��� ���
				System.out.println("��ȸ�� ��������?");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(dtos.size()==0) {
					System.out.println("�ش� ������ �߰��� �ο��� �����ϴ�.");
				}else {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" :	// dao.selectAll() ȣ���Ͽ� ��� ���
				dtos = dao.selectAll();
				if(dtos.isEmpty()) {
					System.out.println("��ϵ� �ο��� �����ϴ�");
				}else {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
				
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
		sc.close();
	}
}
