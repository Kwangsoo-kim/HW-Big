//210107 kks jdbc_preparedS2_update
package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String ssql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String usql = "UPDATE DEPT SET DNAME=?,LOC=? WHERE DEPTNO = ?";
		System.out.println("수정할 부서번호를 입력하세요");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(ssql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("수정할 부서이름을 입력하세요");
				String dname = sc.next();
				System.out.println("수정할 부서위치를 입력하세요");
				sc.nextLine();
				String loc = sc.nextLine();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(usql);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "수정완료" : "수정 실패");
			} else {
				System.out.println("없는 부서입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("수정 실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}
}
