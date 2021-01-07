//210107 kks jdbc_preparedS2_insert
package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String insertsql = "INSERT INTO DEPT VALUES (?,?,?)";
		String selectsql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		System.out.println("�߰��� �μ���ȣ�� �Է��ض�");
		int deptno = sc.nextInt();
		// �ش� �μ���ȣ�� �ִ��� Ȯ�� �� �μ� �߰�
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectsql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("�ش� �μ��� �����ϴ� �μ��Դϴ�.");
			} else {
				System.out.println("�߰��� �μ����� �Է��ض�");
				String dname = sc.next();
				System.out.println("�߰��� �μ���ġ�� �Է��ض�");
				sc.nextLine();
				String loc = sc.nextLine();
				rs.close(); // pstmt �ݱ� ����.
				pstmt.close();
				pstmt = conn.prepareStatement(insertsql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "���� �Ϸ�" : "���� ����");
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
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		sc.close();
	}
}