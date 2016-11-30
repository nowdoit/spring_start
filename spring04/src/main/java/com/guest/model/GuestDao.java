package com.guest.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.OraDB;

public class GuestDao {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List selectAll() throws ClassNotFoundException, SQLException {
		List list = new ArrayList<GuestVo>();
		String sql = "SELECT * FROM guest ORDER BY sabun";
		try {
			pstmt = OraDB.getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new GuestVo(
						rs.getInt("SABUN"),
						rs.getString("NAME"),
						rs.getDate("NALJA"),
						rs.getInt("PAY")
						)
				);
			}
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (OraDB.getConn() != null) OraDB.getConn().close();
		}
		return list;
	}

	public void insertOne(GuestVo bean) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO guest VALUES (?, ?, SYSDATE, ?)";
		try {
			pstmt = OraDB.getConn().prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) pstmt.close();
			if (OraDB.getConn() != null) OraDB.getConn().close();
		}
	}
	
	public void deleteOne(int sabun) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM guest WHERE sabun = ?";
		try {
			pstmt = OraDB.getConn().prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) pstmt.close();
			if (OraDB.getConn() != null) OraDB.getConn().close();
		}
	}
}
