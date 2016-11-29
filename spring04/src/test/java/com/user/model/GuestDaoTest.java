package com.user.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.guest.model.GuestDao;

public class GuestDaoTest {

	private static GuestDao dao;
	
	@BeforeClass
	public static void beforeDao() {
		dao = new GuestDao();
	}
	
	@Test
	public void testSelectAll() {
		try {
			List list = dao.selectAll();
			assertNotNull(list);
			assertTrue(list.size() > 0);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}
}
