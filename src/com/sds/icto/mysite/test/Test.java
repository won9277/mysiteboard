package com.sds.icto.mysite.test;

import java.util.List;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;


public class Test {
	public static void main(String[] args) {
		try {
			testInsert();
			/*testDelete();
			testFetchList();*/
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	public static void testInsert()
		throws Exception {
		BoardDao dao = new BoardDao();
		
		BoardVo vo = new BoardVo();
		vo.setTitle("글 제목");
		vo.setContent("글의 내용");
	//	vo.setMember_no(1);
		vo.setMember_name("s");
		vo.setView_cnt(0);
		dao.insert(vo);
	}

	/*public static void testFetchList()
		throws Exception {
		GuestbookDao dao = new GuestbookDao();
		
		List<GuestbookVo> list = dao.fetchList();
		for( GuestbookVo vo : list ) {
			System.out.print( vo.getNo() + ":");
			System.out.print( vo.getName() + ":");
			System.out.print( vo.getPassword() + ":");
			System.out.print( vo.getMessage() + ":");
			System.out.print( vo.getRegDate() + ":");
			System.out.print( "\n");
		}
	}	
	public static void testDelete()
		throws Exception {
		GuestbookDao dao = new GuestbookDao();

		GuestbookVo vo = new GuestbookVo(); 
		vo.setNo( 16L );
		vo.setPassword( "1234" );
		dao.delete( vo );
		
		vo = new GuestbookVo(); 
		vo.setNo( 17L );
		vo.setPassword( "1234" );
		dao.delete( vo );
	}*/
}