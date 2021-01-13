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
			System.out.println("1 - INSERT | 2 - 직업별 조회 | 3 - 전체 조회 | 그외- 종료");
			fn= sc.next();
			switch (fn) {
			case "1" :	// 이름,직업명, 국영수 입력받아 dao.insertPerson() 호출
				System.out.println("입력할 이름?");
				String pname = sc.next();
				System.out.println("입력할 직업?");
				String jname = sc.next();
				System.out.println("입력할 국어점수?");
				int kor = sc.nextInt();
				System.out.println("입력할 영어점수?");
				int eng = sc.nextInt();
				System.out.println("입력할 수학점수?");
				int mat = sc.nextInt();
				PersonDto nperson = new PersonDto(pname, jname, kor, eng, mat);
				int result = dao.insertPerson(nperson);	//입력끝
				System.out.println(result == PersonDao.SUCCESS? "입력 성공" : "입력 실패");
				break;
			case "2" :	// 직업명 입력받아 dao.selectJname() 호출하여 결과 출력
				System.out.println("조회할 직업명은?");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(dtos.size()==0) {
					System.out.println("해당 직업에 추가된 인원이 없습니다.");
				}else {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" :	// dao.selectAll() 호출하여 결과 출력
				dtos = dao.selectAll();
				if(dtos.isEmpty()) {
					System.out.println("등록된 인원이 없습니다");
				}else {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
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
