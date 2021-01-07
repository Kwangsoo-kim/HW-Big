//210107 kks jdbc_preparedS_delete
package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 삭제할 부서번호를 입력받기
// 부서번호 있을 경우"진짜 xx번 부서를 삭제하시겠습니까?"   Y:삭제 -> "삭제완료" 그외는 삭제안하고 종료.
// 부서번호 없을 경우 "없습니다" 종료.
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String ssql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String dsql = "DELETE FROM DEPT WHERE DEPTNO=?";
		System.out.println("부서번호를 입력하세요 ");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(ssql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("진짜 " + deptno + "부서를 삭제 하시겠습니까? (Y)");
				String yn = sc.next();
				if (yn.equalsIgnoreCase("y")) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(dsql);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "삭제완료" : "삭제실패");
				} else {
					System.out.println("삭제 취소. 종료");
				}
			} else {
				System.out.println("부서번호가 존재하지 않습니다.");
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}
}
