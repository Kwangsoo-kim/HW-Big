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
		System.out.println("업데이트할 부서 번호를 입력하시오");
		String deptno = sc.next(); // int로 해도 되지만 string으로 해도 무관하다.
		System.out.println("수정할 부서의 이름은?");
		String dname = sc.next();
		System.out.println("수정할 부서의 위치는?");
		sc.nextLine();
		String loc = sc.nextLine();
		// DB 수정
		Connection conn = null;
		Statement stmt = null;
		String query = String.format("UPDATE DEPT SET DNAME='%s',LOC='%s' WHERE DEPTNO = %s", dname, loc, deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query);
			System.out.println(result > 0 ? deptno + "번 부서 수정완료" : "해당 부서 존재 안 함.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("수정 실패");
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
