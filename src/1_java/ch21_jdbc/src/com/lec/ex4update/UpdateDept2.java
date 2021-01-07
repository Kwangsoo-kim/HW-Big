//210107 kks jdbc_update_dept2
package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ�� �μ� ��ȣ�� �Է��Ͻÿ�");
		String deptno = sc.next(); // int�� �ص� ������ string���� �ص� �����ϴ�.
		// �Է��� �ش� �μ���ȣ�� �ִ��� ������ üũ
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			if (rs.next()) {
				// rs.next()�� ���̶�� ���� �����ͺ��̽� ���� ���� �μ���ȣ�� �ִٴ� �� �̴�., ���������Ѵ�.
				System.out.println("������ �μ��� �̸���?");
				String dname = sc.next();
				System.out.println("������ �μ��� ��ġ��?");
				sc.nextLine();
				String loc = sc.nextLine();
				String query = String.format("UPDATE DEPT SET DNAME='%s',LOC='%s' WHERE DEPTNO = %s", dname, loc,
						deptno);
				int result = stmt.executeUpdate(query);
				System.out.println(result > 0 ? deptno + "�� �μ� �����Ϸ�" : "�ش� �μ� ���� �� ��.");
			} else {
				System.out.println("��ȿ�� �μ���ȣ�� �ƴմϴ�.");
			}
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("���� ����");
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
