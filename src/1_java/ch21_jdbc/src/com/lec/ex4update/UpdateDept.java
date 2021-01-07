//210107 kks jdbc_update_dept
package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ�� �μ� ��ȣ�� �Է��Ͻÿ�");
		String deptno = sc.next(); // int�� �ص� ������ string���� �ص� �����ϴ�.
		System.out.println("������ �μ��� �̸���?");
		String dname = sc.next();
		System.out.println("������ �μ��� ��ġ��?");
		sc.nextLine();
		String loc = sc.nextLine();
		// DB ����
		Connection conn = null;
		Statement stmt = null;
		String query = String.format("UPDATE DEPT SET DNAME='%s',LOC='%s' WHERE DEPTNO = %s", dname, loc, deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query);
			System.out.println(result > 0 ? deptno + "�� �μ� �����Ϸ�" : "�ش� �μ� ���� �� ��.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("���� ����");
		} finally {
			try {
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
