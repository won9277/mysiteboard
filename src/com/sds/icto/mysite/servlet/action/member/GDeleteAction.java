package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestbookDao;
import com.sds.icto.web.Action;

public class GDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		Long no = Long.parseLong(request.getParameter("no")); 
		String password = request.getParameter("password");
		
		GuestbookDao dao = new GuestbookDao();
		
		dao.delete(no, password);
		
		response.sendRedirect( "/mysite/member?a=guestbook" );

	}

}
