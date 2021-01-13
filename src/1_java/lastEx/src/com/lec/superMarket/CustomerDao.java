package com.lec.superMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static CustomerDao INSTANCE = new CustomerDao();

	public static CustomerDao getInstance() {
		return INSTANCE;
	}

	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// vector
	public Vector<String> getLevelNames() {
		Vector<String> lnames = new Vector<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lnames.add(rs.getString("levelname"));
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
		return lnames;

	}

	// insert
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID,CTEL,CNAME) VALUES (CUS_SEQ.NEXTVAL,?,?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCtel());
			pstmt.setString(2, dto.getCname());
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

	// ctelupdate
	public int updateCustomerTel(String ctel, String cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}

	// pointbuyupdate
	 public int buyWithPoint(int camount, String cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT=CPOINT-? WHERE CID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setString(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}

	// buyupdate
	 public int buy(int camount, String cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CAMOUNT = CAMOUNT+?,CPOINT= CPOINT+?*0.05, "
				+ "        LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L        "
				+ "                WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID =?) "
				+ "                        WHERE CID = ?    ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setString(4, cid);
			pstmt.setString(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}

	// search id
	public ArrayList<CustomerDto> cidgetCustomer(String cid) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID,CTEL, CNAME , CPOINT, CAMOUNT, LEVELNAME, (SELECT HIGH - CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) LVUP"
				+ "        FROM CUSTOMER C, CUS_LEVEL L " + "                WHERE C.LEVELNO=L.LEVELNO"
				+ "                        AND CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cid = Integer.toString(rs.getInt("cid"));
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("levelname");
				int lvup = rs.getInt("lvup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, lname, lvup));
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

	// searchtel
	public ArrayList<CustomerDto> cTelGetCustomers(String ctel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT,LEVELNAME , (SELECT HIGH - CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) LVUP"
				+ "        FROM CUSTOMER C, CUS_LEVEL L " + "                WHERE C.LEVELNO = L.LEVELNO"
				+ "                                        AND C.CTEL IN((SELECT CTEL FROM CUSTOMER WHERE CTEL LIKE '_______%'||?),?) ORDER BY CAMOUNT DESC ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, ctel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String cid = Integer.toString(rs.getInt("cid"));
				String cname = rs.getString("cname");
				ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("levelname");
				int lvup = rs.getInt("lvup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, lname, lvup));
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

	// searchCname
	public ArrayList<CustomerDto> cNameGetCustomers(String cname) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME , CPOINT, CAMOUNT, LEVELNAME,(SELECT HIGH - CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) LVUP"
				+ "        FROM CUSTOMER C, CUS_LEVEL L " + "                WHERE C.LEVELNO=L.LEVELNO"
				+ "                                AND CNAME =? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String cid = Integer.toString(rs.getInt("cid"));
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("levelname");
				int lvup = rs.getInt("lvup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, lname, lvup));
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

	// allout
	public ArrayList<CustomerDto> selectAll() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID ,CTEL,CNAME,CPOINT,CAMOUNT,LEVELNAME, (SELECT HIGH - CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) LVUP"
				+ "         FROM CUSTOMER C, CUS_LEVEL L " + "                WHERE C.LEVELNO=L.LEVELNO ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String cid = Integer.toString(rs.getInt("cid"));
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("levelname");
				int lvup = rs.getInt("lvup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, lname, lvup));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
	// levelout
	public ArrayList<CustomerDto>  levelNameGetCustomers(String lname){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID ,CTEL,CNAME,CPOINT,CAMOUNT,LEVELNAME, (SELECT HIGH - CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) LVUP" + 
				"         FROM CUSTOMER C, CUS_LEVEL L " + 
				"                WHERE C.LEVELNO=L.LEVELNO" + 
				"                                AND LEVELNAME =? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lname);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String cid = Integer.toString(rs.getInt("cid"));
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int lvup = rs.getInt("lvup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, lname, lvup));
				
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
	public int deleteCustomer(String cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
}