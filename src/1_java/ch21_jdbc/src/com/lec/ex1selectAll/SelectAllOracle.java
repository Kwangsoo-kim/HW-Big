//210106 kks jdbc_select_oracle
package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB연결 객체 변수
		Statement stmt = null; // SQL전송 객체 변수
		ResultSet rs = null; // SELECT문 결과 받는 객체 변수
		String sql = "SELECT * FROM EMP";
		try {
			// 1. 드라이버 로드
			Class.forName(driver);
			// 2. DB연결 객체
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// 3. SQL전송 객체 생성
			stmt = conn.createStatement();
			// 4.SQL전송
			// 5.SQL전송결과 받기
			rs = stmt.executeQuery(sql);
			// 6.결과 받아 원하는 로직 수행 - rs에 있는 데이터 콘솔에 출력
			System.out.println("사번\t 이름\t 직책\t\t 상사사번\t 입사일\t\t 급여\t 상여\t 부서번호");
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate"); // Timestamp로도 많이 받는다.String으로 받아된다
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				if (job != null && job.length() < 7) {
					System.out.printf("%d\t %s\t %s\t\t %d\t %TF\t %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal,
							comm, deptno);
				} else {
					System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal, comm,
							deptno);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
