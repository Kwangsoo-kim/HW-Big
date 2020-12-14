package com.lec.ex1_string;
//�پ��� String �� �Լ���~
public class Ex02 {
	public static void main(String[] args) {
		String str1 ="abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "  ja    va    ";
		System.out.println("1. concat : "+str1.concat(str2));//��Ʈ���Լ��� �ٿ�������.
		System.out.println("2. substring : "+str1.substring(3));//3���� ���� ������ 0���ͽ���
		System.out.println("3. substring : "+str1.substring(3,5));//3���� ���� 5�� �ձ���
		System.out.println("4. length : "+str1.length()); //���ڱ���
		System.out.println("5. toUpperCase : "+str1.toUpperCase()); //�빮�ڷ�
		System.out.println("6. toLowerCase : "+str2.toLowerCase()); //�ҹ��ڷ�
		System.out.println("7. charAt : "+str1.charAt(3));//Ư�� ����° ���� 1�� ������
		System.out.println("8. indexOf : "+str1.indexOf("b"));//Ư�� ������ ù ��ġ index�� ������.
		System.out.println("9.indexOf : "+str1.indexOf("b",3));//3index���� ������ ù Ư�������� index�� ������
		System.out.println("10. lastIndexOf : "+str1.lastIndexOf("b")); //Ư�������� ������ ��ġ index�� ������.
		System.out.println("11. indexOf : "+str1.indexOf("z")); //������ -1
		System.out.println("12. equals : "+str1.equals(str2));//true\false
		System.out.println("13. equalsIgnoreCase : "+str1.equalsIgnoreCase(str2));//��ҹ��� ����
		System.out.println("14. trim : "+str3.trim());//�յ� ��������, �߰��� ���ž��Ѵ�.
		System.out.println("15. replace : "+str1.replace('a', '�o'));//��ü 
		System.out.println("16. replace : "+str1.replace("ab", "�ٲ㾾����"));// ��Ʈ���� ��ü����
		System.out.println("���� str1 : "+str1);  //�⺻�̵Ǵ� ��Ʈ���� �ٲ����� �ʴ´�.
	}
}
