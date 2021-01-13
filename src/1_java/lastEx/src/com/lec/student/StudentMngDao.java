//210108 kks lastex3_student
package com.lec.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMngDao {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StudentDao dao = StudentDao.getInsetance();
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		String fn;
		do {
			System.out.println("1 - �л��Է� | 2 - �а�����ȸ | 3 - �����ƴ��л� | 4 - �����л� | ������ ����");
			fn = sc.next();
			switch (fn) {
			case "1" :
				System.out.println("�Է��� �̸� ");
				String sname = sc.next();
				System.out.println("�Է��� �а���");
				String mname = sc.next();
				System.out.println("�Է��� ����");
				int score = sc.nextInt();
				StudentDto dto = new StudentDto(mname, sname, score);
				int result = dao.insertStudent(dto);
				System.out.println(result == StudentDao.SUCCESS? "�Է¼���":"�Է½���");
				break;
			case "2" :
				System.out.println("Ȯ������ �Է��ϼ���");
				mname = sc.next();
				dtos = dao.selectMname(mname);
				if(dtos.size()==0) {
					System.out.println("�ش� �а��� �ο��� �����ϴ�");
				}else {
					System.out.println("���\t�̸�(sNo)\t\t�а�\t����");
					for(StudentDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" :
				dtos = dao.selectAllnoExpel();
				if(dtos.size()==0) {
					System.out.println("�ش� �а��� �ο��� �����ϴ�");
				}else {
					System.out.println("���\t�̸�(sNo)\t\t�а�\t����");
					for(StudentDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "4" :
				dtos = dao.selectAllExpel();
				if(dtos.size()==0) {
					System.out.println("�ش� �а��� �ο��� �����ϴ�");
				}else {
					System.out.println("���\t�̸�(sNo)\t\t�а�\t����");
					for(StudentDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3")||fn.equals("4"));
		System.out.println("BYE");
		sc.close();
	}

}
