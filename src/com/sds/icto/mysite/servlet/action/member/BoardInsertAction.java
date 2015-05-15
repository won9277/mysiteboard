package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.dao.GuestbookDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.mysite.vo.GuestbookVo;
import com.sds.icto.mysite.vo.MemberVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class BoardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		HttpSession session = request.getSession( true );
		MemberVo authMember = (MemberVo) session.getAttribute("authMember");
		
		System.out.println(authMember);
		
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		Long member_no = authMember.getNo();
		String member_name = authMember.getName();
		int view_cnt = 0;
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMember_no(member_no);
		vo.setMember_name(member_name);
		vo.setView_cnt(view_cnt);
		
		BoardDao dao = new BoardDao();
		dao.insert(vo);
		
		List<BoardVo> list = dao.fetchList();
		request.setAttribute("list", list);
		
		view_cnt++;
		
		WebUtil.forward("/views/board/board_list.jsp", request, response);

	}

}
