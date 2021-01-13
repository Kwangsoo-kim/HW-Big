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
			System.out.println("1 - 학생입력 | 2 - 학과별조회 | 3 - 제적아닌학생 | 4 - 제적학생 | 나머지 종료");
			fn = sc.next();
			switch (fn) {
			case "1" :
				System.out.println("입력할 이름 ");
				String sname = sc.next();
				System.out.println("입력할 학과명");
				String mname = sc.next();
				System.out.println("입력할 점수");
				int score = sc.nextInt();
				StudentDto dto = new StudentDto(mname, sname, score);
				int result = dao.insertStudent(dto);
				System.out.println(result == StudentDao.SUCCESS? "입력성공":"입력실패");
				break;
			case "2" :
				System.out.println("확과명을 입력하세요");
				mname = sc.next();
				dtos = dao.selectMname(mname);
				if(dtos.size()==0) {
					System.out.println("해당 학과에 인원이 없습니다");
				}else {
					System.out.println("등수\t이름(sNo)\t\t학과\t점수");
					for(StudentDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" :
				dtos = dao.selectAllnoExpel();
				if(dtos.size()==0) {
					System.out.println("해당 학과에 인원이 없습니다");
				}else {
					System.out.println("등수\t이름(sNo)\t\t학과\t점수");
					for(StudentDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "4" :
				dtos = dao.selectAllExpel();
				if(dtos.size()==0) {
					System.out.println("해당 학과에 인원이 없습니다");
				}else {
					System.out.println("등수\t이름(sNo)\t\t학과\t점수");
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
