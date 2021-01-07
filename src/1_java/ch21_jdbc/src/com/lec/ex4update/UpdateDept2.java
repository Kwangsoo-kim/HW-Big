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
		System.out.println("업데이트할 부서 번호를 입력하시오");
		String deptno = sc.next(); // int로 해도 되지만 string으로 해도 무관하다.
		// 입력한 해당 부서번호가 있는지 없는지 체크
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			if (rs.next()) {
				// rs.next()가 참이라는 것은 데이터베이스 내에 같은 부서번호가 있다는 뜻 이다., 수정진행한다.
				System.out.println("수정할 부서의 이름은?");
				String dname = sc.next();
				System.out.println("수정할 부서의 위치는?");
				sc.nextLine();
				String loc = sc.nextLine();
				String query = String.format("UPDATE DEPT SET DNAME='%s',LOC='%s' WHERE DEPTNO = %s", dname, loc,
						deptno);
				int result = stmt.executeUpdate(query);
				System.out.println(result > 0 ? deptno + "번 부서 수정완료" : "해당 부서 존재 안 함.");
			} else {
				System.out.println("유효한 부서번호가 아닙니다.");
			}
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("수정 실패");
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
