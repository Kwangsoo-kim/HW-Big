package singleton.step2;

public class SecondClass {
	public SecondClass() {
		SingletonClass o2 = SingletonClass.getInstance();
		System.out.println("SecondClass ������ ");
		System.out.println(o2.getI());
		System.out.println("SecondClass ������ ��===");
	}
	
}
