package singleton.step1;

public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println("�ʱ�ȭ�� i �� : "+obj1.getI());
		obj1.setI(999);;
		System.out.println("obj1�� u���� ������ �� obj2�� �� : "+obj2.getI());
		System.out.println("========================================");
		AClass obj3 = AClass.getInstance();
		obj3.setIntVar(991);
		System.out.println(obj3.getIntVar());
		AClass obj4 = AClass.getInstance();
		System.out.println(obj4.getIntVar());
	}
}
