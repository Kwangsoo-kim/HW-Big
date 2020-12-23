package singleton.step2;

public class FirstClass {
	public FirstClass() {
		SingletonClass o1 = SingletonClass.getInstance();
		System.out.println("First Class 형 객체생성");
		System.out.println(o1.getI());
		o1.setI(999);
		System.out.println("i값 변경 후 :(First Class에서) "+o1.getI());
		System.out.println("FirstClass형 생성자 끝");
	}

}
