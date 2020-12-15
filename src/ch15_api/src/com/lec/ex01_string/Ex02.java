package com.lec.ex01_string;
//다양한 String 의 함수들~
public class Ex02 {
	public static void main(String[] args) {
		String str1 ="abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "  ja    va    ";
		System.out.println("1. concat : "+str1.concat(str2));//스트링함수를 붙여버린다.
		System.out.println("2. substring : "+str1.substring(3));//3번쨰 부터 끝가지 0부터시작
		System.out.println("3. substring : "+str1.substring(3,5));//3번쨰 부터 5번 앞까지
		System.out.println("4. length : "+str1.length()); //문자길이
		System.out.println("5. toUpperCase : "+str1.toUpperCase()); //대문자로
		System.out.println("6. toLowerCase : "+str2.toLowerCase()); //소문자로
		System.out.println("7. charAt : "+str1.charAt(3));//특정 순번째 문자 1개 가져옴
		System.out.println("8. indexOf : "+str1.indexOf("b"));//특정 문자의 첫 위치 index를 가져옴.
		System.out.println("9.indexOf : "+str1.indexOf("b",3));//3index부터 나오는 첫 특정문자의 index를 가져옴
		System.out.println("10. lastIndexOf : "+str1.lastIndexOf("b")); //특정문자의 마지막 위치 index를 가져옴.
		System.out.println("11. indexOf : "+str1.indexOf("z")); //없으면 -1
		System.out.println("12. equals : "+str1.equals(str2));//true\false
		System.out.println("13. equalsIgnoreCase : "+str1.equalsIgnoreCase(str2));//대소문자 무시
		System.out.println("14. trim : "+str3.trim());//앞뒤 공백제거, 중간은 제거안한다.
		System.out.println("15. replace : "+str1.replace('a', '뭥'));//대체 
		System.out.println("16. replace : "+str1.replace("ab", "바꿔씨엑스"));// 스트링도 대체가능
		System.out.println("최종 str1 : "+str1);  //기본이되는 스트링을 바꾸지는 않는다.
	}
}
