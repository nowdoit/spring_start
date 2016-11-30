package com.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.user.model.LoginBean;
import com.user.model.UserDao;
import com.user.model.UserVo;

public class LoginController implements Controller {
	private UserDao dao;
	private LoginBean login;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = req.getParameter("id").trim();
		String pw = req.getParameter("pw").trim();
		UserVo bean = dao.login(id, pw);
		if (bean.getLogin().equalsIgnoreCase("true")) {
//			HttpSession session = req.getSession();
//			session.setAttribute("result", true);
//			session.setAttribute("id", id);
			System.out.println("before:" + login);
			login.setResult(true);
			login.setId(id);
			System.out.println("after:" + login);
			mav.setViewName("redirect:bbs/list");
		} else {
			mav.addObject("errMsg", "로그인 실패");
			mav.setViewName("user/login");
		}
		return mav;
	}

}
