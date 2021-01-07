//210106 kks jdbc_select_deptno
package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*	����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾�
 * 	(1) �ش� �μ���ȣ�� �����ϴ� ��� : �μ����� ���, ���(���,�̸�,�޿�,����̸�)�� ������ ��� ����Ʈ ���, �������� ���� ��� ����� ���ٰ� ���
 * 	(2) �ش� �μ���ȣ�� �������� ���� ��� : �������� �ʴ� �μ���ȣ��� ���
*/
public class SelectWhereDeptno3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ� ��ȣ�� �Է��ϼ���");
		int deptnosc = sc.nextInt();
		String sql = "SELECT DNAME , LOC FROM DEPT WHERE DEPTNO = "+ deptnosc;
		String sql2 = "SELECT W.EMPNO wno,W.ENAME wname,W.SAL wsal,M.ENAME mname FROM EMP W, EMP M WHERE W.MGR=M.EMPNO AND W.DEPTNO ="+ deptnosc;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptnosc + "�� �μ��� ������ ������ �����ϴ�.");
				System.out.println("�μ��� : " + dname);
				System.out.println("��ġ : " + loc);
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					do {
						int empno = rs.getInt("wno");
						String wename = rs.getString("wname");
						int sal = rs.getInt("wsal");
						String mename = rs.getString("mname");
						System.out
								.println("��� : " + empno + "\t�̸� : " + wename + "\t�޿� : " + sal + "\t����̸� : " + mename);
					} while (rs.next());
				} else {
					System.out.println("������������� �ʽ��ϴ�.");
				}

			} else {
				System.out.println("�������� �ʴ� �μ���ȣ �Դϴ�.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + 1);
		} catch (SQLException e) {
			System.out.println(e.getMessage() + 2);
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