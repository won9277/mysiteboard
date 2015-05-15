package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestbookDao;
import com.sds.icto.mysite.vo.GuestbookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class GuestbookInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String message = request.getParameter("message");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		GuestbookDao dao = new GuestbookDao();
		dao.insert(vo);
		
		List<GuestbookVo> list = dao.fetchList();
		request.setAttribute("list", list);
		
		WebUtil.forward("/views/guestbook/list.jsp", request, response);
	}

}
