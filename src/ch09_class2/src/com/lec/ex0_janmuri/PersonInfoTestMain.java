package com.lec.ex0_janmuri;

class PersonInfo {
	private String name;
	private int age;
	private char gender; // 성별 '남', '여'

	public PersonInfo() {
	}// 생성자 없을경우 디폴트생성자는 자동생성

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}// 생성자 오버로딩

	public void print() {
		System.out.println("이름 = " + name + "  나이 = " + age + "\t 성별 = " + gender);
	}

	public String infoString() {
		String result = "이름 = " + name + "  나이 = " + age + "\t 성별 = " + gender;
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
				new PersonInfo("홍길동",20,'남'), new PersonInfo("홍길순",22,'여'), new PersonInfo()
		};
		person[2].setName("홍길숙");
		person[2].setAge(30);
		person[2].setGender('여');
//		for(int i=0;i<person.length;i++ ) {
//			System.out.println(person[i].infoString());
//		}
		for(PersonInfo p : person) {
			p.print();
		}
		

	}
}
