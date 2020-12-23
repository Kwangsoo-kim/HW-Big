import java.util.Scanner;

//201216 kks Scanner2
public class ExScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String na = sc.next();
		System.out.println("엽력한 이름은 "+ na);
		nn();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println("입력한 나이는 : "+age);
		sc.close();
	}
	private static void nn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("별명을 입력하세요");
		String nn =sc.next();
		System.out.println("볆명은 : "+nn);
		//메인함수에 호출될 scanner함수는 sc.close를 하면안된다. scanner자체가 닫힌다.
	}
}
