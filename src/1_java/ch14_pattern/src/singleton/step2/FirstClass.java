package singleton.step2;

public class FirstClass {
	public FirstClass() {
		SingletonClass o1 = SingletonClass.getInstance();
		System.out.println("First Class �� ��ü����");
		System.out.println(o1.getI());
		o1.setI(999);
		System.out.println("i�� ���� �� :(First Class����) "+o1.getI());
		System.out.println("FirstClass�� ������ ��");
	}

}
