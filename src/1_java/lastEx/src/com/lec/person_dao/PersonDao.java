//210107 kks lastex2_dao
package com.lec.person_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// PersonDao dao = new PersonDao();
public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static PersonDao INSTANCE = new PersonDao();

	public static PersonDao getInsetance() {
		return INSTANCE;
	}

	private PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번 insert
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// dto값들을 DB에 넣기
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insertSql = "INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 2번 직업select
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// jname 직업인 사람들 리스트 dtos에 add하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSql = "SELECT ROWNUM RANK, S.*"
				+ "        FROM (SELECT PNAME ||'('||NO||'번)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM"
				+ "        FROM PERSON P, JOB J" + "                WHERE P.JNO=J.JNO"
				+ "                        AND JNAME =?" + "                                ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
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
		return dtos;
	}

	// 3번 seletall
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String allsql = "SELECT ROWNUM RANK, S.*"
				+ "        FROM (SELECT PNAME ||'('||NO||'번)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM"
				+ "        FROM PERSON P, JOB J" + "                WHERE P.JNO=J.JNO"
				+ "                                ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(allsql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
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

		return dtos;
	}
}
