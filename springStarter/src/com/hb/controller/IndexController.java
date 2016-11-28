package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {
	private String msg;
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
//		req.setAttribute("msg", "Spring");
		mav.setViewName("index"); //사용할 jsp 파일명
		return mav;
	}

}
