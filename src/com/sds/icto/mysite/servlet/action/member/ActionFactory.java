package com.sds.icto.mysite.servlet.action.member;

import com.sds.icto.mysite.servlet.action.main.IndexAction;
import com.sds.icto.web.Action;

public class ActionFactory {
	private static ActionFactory instance;
	static {
		instance = new ActionFactory(); 
	}
	
	private ActionFactory(){
	}
	
	public static ActionFactory getInstance() {
//		if( instance == null ) {
//			instance = new ActionFactory(); 
//		}
		return instance;
	}
	
	public Action getAction( String a ) {
		Action action = null;
		
		if( "joinform".equals( a ) ) {
			action = new JoinFormAction();
		} else if( "join".equals( a ) ) {
			action = new JoinAction();
		} else if( "joinsuccess".equals( a ) ) {
			action = new JoinSuccessAction();
		} else if( "loginform".equals( a ) ) {
			action = new LoginFormAction();
		} else if( "login".equals( a ) ) {
			action = new LoginAction();
		} else if( "logout".equals( a ) ) {
			action = new LogoutAction();
		} else if( "uinfo".equals( a ) ) {
			
		}else if( "insert".equals( a ) ) {
			action = new GuestbookInsertAction();
		}else if( "guestbook".equals( a ) ) {
			action = new GuestbookAction();
		}else if( "gdelete".equals( a ) ) {
			action = new GDeleteAction();
		}else if("board_list".equals(a)){
			action = new BoardListAction();
		}else if("insertBoard".equals(a)){
			action = new BoardInsertAction();
		}else if("insertBoardPage".equals(a)){
			action = new BoardInsertPageAction();
		}else if("getboard".equals(a)){
			action = new GetBoardAction();
		}else if("bmodifypage".equals(a)){
			action = new ModifyBoardPageAction();
		}else if("bmodify".equals(a)){
			action = new ModifyBoardAction();
		}else if("bdelete".equals(a)){
			action = new DeleteBoardAction();
		}
		
		if( action == null ) {
			action = new IndexAction();
		}
		
		return action;
	}
}
