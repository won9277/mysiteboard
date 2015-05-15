package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sds.icto.mysite.vo.BoardVo;


public class BoardDao {
	
	//글 입력
	public void insert(BoardVo vo ) 
		throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		
		String sql = "insert into board values(guestbook_seq.nextval,?,?,?,?,?, SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement( sql );
		
		pstmt.setString( 1, vo.getTitle());
		pstmt.setString( 2, vo.getContent());
		pstmt.setLong( 3, vo.getMember_no() );
		pstmt.setString( 4, vo.getMember_name() );
		pstmt.setInt( 5, vo.getView_cnt() );
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	//글 리스트 불러오기
	public List<BoardVo> fetchList()
		throws ClassNotFoundException, SQLException { 
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "select * from board";
		ResultSet rs = stmt.executeQuery( sql );
		
		while( rs.next() ) {
			int no = rs.getInt( 1 );
			String title = rs.getString( 2 );
			String content = rs.getString ( 3 );
			Long member_no = rs.getLong( 4 );
			String member_name = rs.getString( 5 );
			int view_cnt = rs.getInt( 6 );
			Date regDate = rs.getDate( 7 );
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMember_no(member_no);
			vo.setMember_name(member_name);
			vo.setView_cnt(view_cnt);
			vo.setReg_date(regDate);
			
			list.add( vo );
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	
	//글 삭제
	public void delete()
		throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "delete from board";
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
	}
	
	//no받아서 글 삭제
	public void delete(int no )
		throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "delete from board where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt( 1, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}


	//글 상세 페이지
	public BoardVo getBoard(int no) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		
		BoardVo vo = null;
		
		String sql = "select * from board where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
		no = rs.getInt( 1 );
		String title = rs.getString( 2 );
		String content = rs.getString ( 3 );
		Long member_no = rs.getLong( 4 );
		String member_name = rs.getString( 5 );
		int view_cnt = rs.getInt( 6 );
		Date regDate = rs.getDate( 7 );
			
		vo = new BoardVo();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMember_no(member_no);
		vo.setMember_name(member_name);
		vo.setView_cnt(view_cnt);
		vo.setReg_date(regDate);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return vo; 
	}
	
	//글 수정
	public void updateBoard(BoardVo vo) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		
		String sql = "update board set title=?, content=?, reg_date=sysdate where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString( 1, vo.getTitle());
		pstmt.setString( 2, vo.getContent());
		pstmt.setInt( 3, vo.getNo() );
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	
	}
	
	private Connection getConnection()
		throws ClassNotFoundException, SQLException {
		Connection conn = null;
		//1. 드라이버 로딩
		Class.forName( "oracle.jdbc.driver.OracleDriver" );
		//2. connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}
	
}
