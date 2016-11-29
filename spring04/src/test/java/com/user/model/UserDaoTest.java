package com.user.model;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest{
	private static UserDao dao;
	
	@BeforeClass
	public static void beforeDao() {
		dao = new UserDao();
	}
	
	@Test
	public void testLodgin() throws ClassNotFoundException, SQLException {
		UserVo bean = dao.login("admin","1234");
		assertTrue("true".equalsIgnoreCase(bean.getLogin()));
		bean = dao.login("admin","1111");
		assertTrue("false".equalsIgnoreCase(bean.getLogin()));
		bean = dao.login("root","1111");
		assertTrue("false".equalsIgnoreCase(bean.getLogin()));
		bean = dao.login("root","1234");
		assertTrue("false".equalsIgnoreCase(bean.getLogin()));
	}

}
