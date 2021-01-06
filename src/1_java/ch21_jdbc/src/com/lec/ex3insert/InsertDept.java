//210106 kks jdbc_insert_dept
package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 부서 번호는?");
		int deptno = sc.nextInt();
		System.out.println("입력할 부서 이름은?");
		String dname = sc.next();
		System.out.println("입려할 부서의 위치는?");
		sc.nextLine(); // '\n'버퍼 clear
		String loc = sc.nextLine(); // 띄어쓰기 인식
		Connection conn = null;
		Statement stmt = null;
		String sql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql); // insert,delete,update 쓸땐 executeUpdate 사용
			System.out.println(result > 0 ? "부서입력성공" : "부서입력실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		sc.close();
	}
}
