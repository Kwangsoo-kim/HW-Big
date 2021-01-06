//210106 kks jdbc_select_dname
package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �μ����� �Է¹޾� �ش� �μ��� ������ ��� ����Ʈ ���(���,�̸�,�޿�,�޿����)
public class SelectWhereDname2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("�μ����� �Է��Ͻÿ�");
		Scanner sc = new Scanner(System.in);
		String dname = sc.next();
		String sql1;
		String sql2;
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = '%s'", dname.toUpperCase());
		sql2 = String.format("SELECT EMPNO,ENAME,SAL,GRADE" + 
				"        FROM EMP E, SALGRADE , DEPT D" + 
				"                WHERE SAL BETWEEN LOSAL AND HISAL" + 
				"                        AND E.DEPTNO =D.DEPTNO" + 
				"                                AND DNAME = '%s' ", dname.toUpperCase());
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println(" �μ���ȣ : "+ rs.getInt("deptno"));
				System.out.println(" �μ��̸� : "+ dname);
				System.out.println(" �μ���ġ : "+ rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.printf("��� : "+empno+"\t�̸� : "+ename+"\t�޿� : "+sal+"\t��� : "+grade+"\n");
					}while(rs.next());
				}else {
					System.out.println("�ش� �μ��� ����� �������� �ʽ��ϴ�.");
				}
			}else {
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		sc.close();
	}
}
