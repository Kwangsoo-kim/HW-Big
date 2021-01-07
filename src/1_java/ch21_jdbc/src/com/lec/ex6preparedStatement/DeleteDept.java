//210107 kks jdbc_preparedS_delete
package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// ������ �μ���ȣ�� �Է¹ޱ�
// �μ���ȣ ���� ���"��¥ xx�� �μ��� �����Ͻðڽ��ϱ�?"   Y:���� -> "�����Ϸ�" �׿ܴ� �������ϰ� ����.
// �μ���ȣ ���� ��� "�����ϴ�" ����.
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String ssql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String dsql = "DELETE FROM DEPT WHERE DEPTNO=?";
		System.out.println("�μ���ȣ�� �Է��ϼ��� ");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(ssql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("��¥ " + deptno + "�μ��� ���� �Ͻðڽ��ϱ�? (Y)");
				String yn = sc.next();
				if (yn.equalsIgnoreCase("y")) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(dsql);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "�����Ϸ�" : "��������");
				} else {
					System.out.println("���� ���. ����");
				}
			} else {
				System.out.println("�μ���ȣ�� �������� �ʽ��ϴ�.");
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
