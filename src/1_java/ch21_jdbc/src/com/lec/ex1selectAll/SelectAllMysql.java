//210106 kks jdbc_select_mysql
package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllMysql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PERSONAL";
		try {
			Class.forName(driver); // 1.드라이버 로드
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2. DB연결 객체
			stmt = conn.createStatement(); // 3. SQL 전송객체
			rs = stmt.executeQuery(query); // 4. SQL 전송 5. SQL 전송 결과 받기
			System.out.println("사번\t 이름\t 직책\t\t 상사사번\t 입사일\t\t 급여\t 상여\t 부서번호");
			if (rs.next()) {// select 결과 있음
				do {
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					String manager = rs.getString("manager");
					Timestamp startdate = rs.getTimestamp("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					if (pname != null && pname.length() < 7 ) {
						System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\t\n", pno, pname, job, manager,
								startdate, pay, bonus, dno);
					} else {
						System.out.printf("%d\t %s %s\t %s\t %TF\t %d\t %d\t %d\t\n", pno, pname, job, manager,
								startdate, pay, bonus, dno);
					}
				} while (rs.next());
			} else {
				System.out.println("사원 정보가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			;
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
	}
}
