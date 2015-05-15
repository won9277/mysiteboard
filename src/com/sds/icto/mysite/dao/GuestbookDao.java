package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.GuestbookVo;


public class GuestbookDao {

	public void insert( GuestbookVo vo ) 
		throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		
		String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?, SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement( sql );
		
		pstmt.setString( 1, vo.getName() );
		pstmt.setString( 2, vo.getPassword() );
		pstmt.setString( 3, vo.getMessage() );
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public List<GuestbookVo> fetchList()
		throws ClassNotFoundException, SQLException { 
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "select * from guestbook";
		ResultSet rs = stmt.executeQuery( sql );
		
		while( rs.next() ) {
			Long no = rs.getLong( 1 );
			String name = rs.getString( 2 );
			String password = rs.getString ( 3 );
			String message = rs.getString( 4 );
			String regDate = rs.getString( 5 );
			
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setRegDate(regDate);
			
			list.add( vo );
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	
	public void delete()
		throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "delete from guestbook";
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
	}
	
	public void delete(Long no, String password )
		throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "delete from guestbook where no = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong( 1, no);
		pstmt.setString( 2, password );
		
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
