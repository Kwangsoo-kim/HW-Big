package singleton.step2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass s1 = new FirstClass();
		SecondClass s2 = new SecondClass();
		SingletonClass o3 = SingletonClass.getInstance();
		System.out.println("���θ޼ҵ忡�� o3���� i����?");
		System.out.println(o3.getI());
	}
}
