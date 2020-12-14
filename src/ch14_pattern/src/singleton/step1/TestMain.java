package singleton.step1;

public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println("초기화된 i 값 : "+obj1.getI());
		obj1.setI(999);;
		System.out.println("obj1의 u값을 변경한 후 obj2의 값 : "+obj2.getI());
		System.out.println("========================================");
		AClass obj3 = AClass.getInstance();
		obj3.setIntVar(991);
		System.out.println(obj3.getIntVar());
		AClass obj4 = AClass.getInstance();
		System.out.println(obj4.getIntVar());
	}
}
