package strategy3.modularization;

public class TestMain {
	public static void main(String[] args) {
		Student s1 = new Student("30301","���л�","���̽��");
		Student s2 = new Student("32201","������","�ڹٹ�");
		Lecturer l1 = new Lecturer("j01","ȫ����", "�ϵӹ�");
		Lecturer l2 = new Lecturer("j02","�����", "�������");
		Staff f1 = new Staff("A01","������","���������");
		Person[] p = {s1,s2,l1,l2,f1};
		
		System.out.println("�����ð��̴� �� ���սô�.");
		for(Person i : p) {
			i.job();
		}
		System.out.println("������ �� ������ �� ����");
		for(Person i : p) {
			i.get();
		}
		System.out.println("�ñ��ϸ� ����Ʈ");
		for(Person i : p) {
			i.print();
		}
	}
}