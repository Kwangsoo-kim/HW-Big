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
			//	1. ����̹� �ε�
			Class.forName(driver);
			System.out.println("����̺� �ε� ����");
			//	2. DB���� ��ü
			conn = DriverManager.getConnection(url,"root","mysql");
			System.out.println("mysql DB���� ����");
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