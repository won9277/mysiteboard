package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.dao.GuestbookDao;
import com.sds.icto.web.Action;

public class DeleteBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		int no = Integer.parseInt(request.getParameter("no")); 
		
		BoardDao dao = new BoardDao();
		
		dao.delete(no);
		
		response.sendRedirect( "/mysite/member?a=board_list" );
	}

}
