package singleton.step2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass s1 = new FirstClass();
		SecondClass s2 = new SecondClass();
		SingletonClass o3 = SingletonClass.getInstance();
		System.out.println("메인메소드에서 o3안의 i값은?");
		System.out.println(o3.getI());
	}
}
