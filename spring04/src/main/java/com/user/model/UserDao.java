package com.user.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hb.util.OraDB;

public class UserDao {

	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserVo login(String id, String pw) throws ClassNotFoundException, SQLException {
		UserVo bean = new UserVo();
		String sql = "SELECT 'true' AS login, id FROM users WHERE id = ? AND pw = ?";
		try {
			pstmt = OraDB.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) { //등록된 사용자에 대한 처리
				bean.setLogin(rs.getString("LOGIN"));
				bean.setId(id);
			} else {
				bean.setLogin("false");
				bean.setId("guest");
			}
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (OraDB.getConn() != null) OraDB.getConn().close();
		}
		return bean;
	}
}
