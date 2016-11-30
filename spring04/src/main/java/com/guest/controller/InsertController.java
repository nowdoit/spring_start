package com.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.guest.model.GuestDao;
import com.guest.model.GuestVo;

public class InsertController extends AbstractCommandController {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
//	public InsertController() {
//		setCommandClass(GuestVo.class);
//	}
	@Override
	protected ModelAndView handle(HttpServletRequest req,
			HttpServletResponse res, Object obj, BindException be)
			throws Exception {
		System.out.println((GuestVo)obj);
		GuestVo bean = (GuestVo)obj;
		dao.insertOne(bean);
		return new ModelAndView("redirect:list.do");
	}

}
