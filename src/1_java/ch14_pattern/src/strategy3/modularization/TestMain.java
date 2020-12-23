package strategy3.modularization;

public class TestMain {
	public static void main(String[] args) {
		Student s1 = new Student("30301","강학생","파이썬반");
		Student s2 = new Student("32201","강공생","자바반");
		Lecturer l1 = new Lecturer("j01","홍강의", "하둡반");
		Lecturer l2 = new Lecturer("j02","김수업", "몽고디비반");
		Staff f1 = new Staff("A01","신일해","취업지원부");
		Person[] p = {s1,s2,l1,l2,f1};
		
		System.out.println("업무시간이니 다 일합시다.");
		for(Person i : p) {
			i.job();
		}
		System.out.println("월말엔 다 지급할 것 지급");
		for(Person i : p) {
			i.get();
		}
		System.out.println("궁금하면 프린트");
		for(Person i : p) {
			i.print();
		}
	}
}