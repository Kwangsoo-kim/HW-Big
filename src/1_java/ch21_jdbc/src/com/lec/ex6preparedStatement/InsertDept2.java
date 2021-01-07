//210107 kks jdbc_preparedS2_insert
package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String insertsql = "INSERT INTO DEPT VALUES (?,?,?)";
		String selectsql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		System.out.println("추가할 부서번호를 입력해라");
		int deptno = sc.nextInt();
		// 해당 부서번호가 있는지 확인 후 부서 추가
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectsql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("해당 부서는 존재하는 부서입니다.");
			} else {
				System.out.println("추가할 부서명을 입력해라");
				String dname = sc.next();
				System.out.println("추가할 부서위치를 입력해라");
				sc.nextLine();
				String loc = sc.nextLine();
				rs.close(); // pstmt 닫기 전에.
				pstmt.close();
				pstmt = conn.prepareStatement(insertsql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "생성 완료" : "생성 실패");
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
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		sc.close();
	}
}
