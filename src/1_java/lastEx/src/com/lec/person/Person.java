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
			System.out.println("1 - INSERT | 2 - ������ ��ȸ | 3 - ��ü ��ȸ | �׿�- ����");
			fn = sc.next();
			switch (fn) {
			case "1": // �̸�, ������, ����, ����, ������ �Է¹޾� insert
				System.out.println("�Է��� �̸�?");
				String pname = sc.next();
				System.out.println("������(��� | ���� | ����)? ");
				String jname = sc.next();
				System.out.println("���� ����?");
				int kor = sc.nextInt();
				System.out.println("���� ����?");
				int eng = sc.nextInt();
				System.out.println("���� ����?");
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
					System.out.println(result > 0 ? "�Է� ����" : "�Է� ����");
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
			case "2": // �������� �Է¹޾� ������ ���
				System.out.println("�������� �Է��Ͻÿ�(��� | ���� | ����)");
				jname = sc.next();
				String selectSql = "SELECT ROWNUM RANK, S.*"
						+ "        FROM (SELECT PNAME ||'('||NO||'��)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM"
						+ "        FROM PERSON P, JOB J" + "                WHERE P.JNO=J.JNO"
						+ "                        AND JNAME =?"
						+ "                                ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(selectSql);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
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
						System.out.println("�ش������� ����� �����ϴ�.");
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
						+ "        FROM (SELECT PNAME ||'('||NO||'��)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM"
						+ "        FROM PERSON P, JOB J" + "                WHERE P.JNO=J.JNO"
						+ "                                ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(selectSql2);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
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
						System.out.println("�ش������� ����� �����ϴ�.");
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
