import java.util.Scanner;

//201216 kks Scanner2
public class ExScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String na = sc.next();
		System.out.println("������ �̸��� "+ na);
		nn();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.println("�Է��� ���̴� : "+age);
		sc.close();
	}
	private static void nn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		String nn =sc.next();
		System.out.println("�Ӹ��� : "+nn);
		//�����Լ��� ȣ��� scanner�Լ��� sc.close�� �ϸ�ȵȴ�. scanner��ü�� ������.
	}
}
