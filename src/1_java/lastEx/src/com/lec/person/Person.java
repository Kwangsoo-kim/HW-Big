//210107 kks lastex1
package com.lec.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String fn;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.println("1 - INSERT | 2 - 직업별 조회 | 3 - 전체 조회 | 그외- 종료");
			fn = sc.next();
			switch (fn) {
			case "1": // 이름, 직업명, 국어, 영어, 수학을 입력받아 insert
				System.out.println("입력할 이름?");
				String pname = sc.next();
				System.out.println("직업명(배우 | 가수 | 엠씨)? ");
				String jname = sc.next();
				System.out.println("국어 점수?");
				int kor = sc.nextInt();
				System.out.println("영어 점수?");
				int eng = sc.nextInt();
				System.out.println("수학 점수?");
				int mat = sc.nextInt();
				String insertSql = "INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(insertSql);
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "입력 성공" : "입력 실패");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2": // 직업명을 입력받아 직업별 출력
				System.out.println("직업명을 입력하시오(배우 | 가수 | 엠씨)");
				jname = sc.next();
				String selectSql = "SELECT ROWNUM RANK, S.*"
						+ "        FROM (SELECT PNAME ||'('||NO||'번)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM"
						+ "        FROM PERSON P, JOB J" + "                WHERE P.JNO=J.JNO"
						+ "                        AND JNAME =?"
						+ "                                ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(selectSql);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							pname = rs.getString("pname");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							if (pname != null && pname.length() <7) {
								System.out.println(rank + "\t" + pname + "\t\t" + jname + "\t" + kor + "\t" + eng + "\t"
										+ mat + "t" + sum);
							} else {
								System.out.println(rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t"
										+ mat + "t" + sum);
							}
						} while (rs.next());
					} else {
						System.out.println("해당직업에 사람이 없습니다.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				break;
			case "3":
				String selectSql2 = "SELECT ROWNUM RANK, S.*"
						+ "        FROM (SELECT PNAME ||'('||NO||'번)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM"
						+ "        FROM PERSON P, JOB J" + "                WHERE P.JNO=J.JNO"
						+ "                                ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(selectSql2);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							pname = rs.getString("pname");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							if (pname != null && pname.length() <7) {
								System.out.println(rank + "\t" + pname + "\t\t" + jname + "\t" + kor + "\t" + eng + "\t"
										+ mat + "\t" + sum);
							} else {
								System.out.println(rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t"
										+ mat + "\t" + sum);
							}
						} while (rs.next());
					} else {
						System.out.println("해당직업에 사람이 없습니다.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
		sc.close();
	}
}
