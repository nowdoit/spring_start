package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.OraDB;

public class GuestDao {

	Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public GuestDao() throws ClassNotFoundException, SQLException {
		
	}
	public List selectAll() {
		String sql = "SELECT * FROM guest";
		try {
			conn = OraDB.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<GuestVo> list = new ArrayList<GuestVo>();
			while (rs.next()) {
				list.add(new GuestVo(
						rs.getInt("SABUN"),
						rs.getString("NAME"),
						rs.getDate("NALJA"),
						rs.getInt("PAY")
						)
				);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public void insertOne(GuestVo bean) {
		String sql = "INSERT INTO guest VALUES (?, ?, SYSDATE, ?)";
		try {
			conn = OraDB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public GuestVo selectOne(int sabun) {
		String sql = "SELECT * FROM guest WHERE sabun = ?";
		try {
			conn = OraDB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new GuestVo(
					rs.getInt("SABUN"),
					rs.getString("NAME"),
					rs.getDate("NALJA"),
					rs.getInt("PAY")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public void updateOne(GuestVo vo) {
		String sql = "UPDATE guest SET name = ?, pay = ? WHERE sabun = ?";
		try {
			conn = OraDB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPay());
			pstmt.setInt(3, vo.getSabun());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteOne(int sabun) {
		String sql = "DELETE FROM guest WHERE sabun = ?";
		try {
			conn = OraDB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

} //class end
