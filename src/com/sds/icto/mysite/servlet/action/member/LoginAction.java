package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.MemberDao;
import com.sds.icto.mysite.vo.MemberVo;
import com.sds.icto.web.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );
		
		MemberVo vo = new MemberVo();
		vo.setEmail(email);
		vo.setPassword(password);
		
		MemberDao dao = new MemberDao();
		MemberVo authMember = dao.getMember(vo);
		
		// 비밀번호나 이메일 에러
		if( authMember == null ) {
			response.sendRedirect( "/mysite/member?a=loginform&result=fail" );
			return;
		}
		
		// 인증처리(로그인처리)
		HttpSession session = request.getSession( true );
		session.setAttribute("authMember", authMember );
		response.sendRedirect( "/mysite/" );
		
	}

}
