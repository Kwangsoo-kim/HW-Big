//210106 kks jdbc_select_deptno
package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//	����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ����� �Ѹ��� 
public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� �μ���ȣ�� �Է��ϼ���");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) { // �ش�μ��� �ִ�
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "�� �μ��� ������ ������ �����ϴ�.");
				System.out.println("�μ��� : " + dname);
				System.out.println("��ġ : " + loc);
			} else { // �ش�μ��� ����
				System.out.println("�ش� �μ��� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		sc.close();
	}
}
