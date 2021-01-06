//210106 kks jdbc_conn_mysql
package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMysql {
	public static void main(String[] args) {
		String driver ="com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		try {
			//	1. 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이브 로드 성공");
			//	2. DB연결 객체
			conn = DriverManager.getConnection(url,"root","mysql");
			System.out.println("mysql DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+1);
		} catch (SQLException e) {
			System.out.println(e.getMessage()+2);
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {}
		}
	}
}
