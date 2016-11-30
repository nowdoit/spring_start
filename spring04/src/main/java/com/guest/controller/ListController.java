package com.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.guest.model.GuestDao;
import com.guest.model.GuestVo;
import com.user.model.LoginBean;

public class ListController implements Controller {
	private GuestDao dao;
	private LoginBean login;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		//세션검사
//		HttpSession session = req.getSession();
//		Object result = session.getAttribute("result");
//		if (result != null && (Boolean)result) {
//			//mav.setViewName("user/login");
//			//return mav;
//			mav.addObject("loginOk", result);
//		} else {
//			mav.addObject("loginGo", result);
//		}
		
		if (login.isResult()) {
			mav.addObject("loginOk", true);
		} else {
			mav.addObject("loginGo", true);
		}
		System.out.println(login);
		
		List<GuestVo> list = dao.selectAll();
		mav.addObject("alist", list);
		mav.setViewName("guest/list");
		return mav;
	}

}
