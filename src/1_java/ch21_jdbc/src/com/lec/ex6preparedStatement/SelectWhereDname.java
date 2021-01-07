//210107 kks jdbc_preparedS2_select
package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// �μ��̸��� �Է¹޾� �ش� �μ��� ���, �̸� ,job ,sal ���
public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String sql = "SELECT EMPNO,ENAME,JOB,SAL" + "        FROM EMP E , DEPT D     "
				+ "                WHERE E.DEPTNO =D.DEPTNO" + "                       "
											+ " AND DNAME =?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.println("�μ����� �Է��ϼ���");
			pstmt.setString(1, sc.next().toUpperCase());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("���\t�̸�\t��å\t\t�޿�");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					if (job != null && job.length() <=7) {
						System.out.println(empno + "\t" + ename + "\t" + job + "\t\t" + sal);
					} else {
						System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
					}
				} while (rs.next());
			} else {
				System.out.println("�ش�μ��� ������ �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
		sc.close();

	}
}
