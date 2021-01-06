//210106 kks jdbc_select_deptno
package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*	사용자에게 원하는 부서번호를 입력받아
 * 	(1) 해당 부서번호가 존재하는 경우 : 부서정보 출력, 사원(사번,이름,급여,상사이름)이 존재할 경우 리스트 출력, 존재하지 않은 경우 사원이 없다고 출력
 * 	(2) 해당 부서번호가 존재하지 않을 경우 : 존재하지 않는 부서번호라고 출력
*/
public class SelectWhereDeptno3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("부서 번호를 입력하세요");
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
				System.out.println(deptnosc + "번 부서의 정보는 다음과 같습니다.");
				System.out.println("부서명 : " + dname);
				System.out.println("위치 : " + loc);
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					do {
						int empno = rs.getInt("wno");
						String wename = rs.getString("wname");
						int sal = rs.getInt("wsal");
						String mename = rs.getString("mname");
						System.out
								.println("사번 : " + empno + "\t이름 : " + wename + "\t급여 : " + sal + "\t상사이름 : " + mename);
					} while (rs.next());
				} else {
					System.out.println("사원이존재하지 않습니다.");
				}

			} else {
				System.out.println("존재하지 않는 부서번호 입니다.");
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
