package kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.action.BoardCheckPasswordProc;
import kosta.action.BoardDeleteAction;
import kosta.action.BoardDetailViewAction;
import kosta.action.BoardInsertFormAction;
import kosta.action.BoardInsertProcAction;
import kosta.action.BoardListAction;
import kosta.action.BoardModifyFormAction;
import kosta.action.BoardModifyProcAction;
import kosta.action.BoardPasswoardFormAction;
import kosta.action.ErrorAction;
import kosta.action.ReplyInsertProcAction;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String[] path = requestURI.split("/");
    	String command = path[path.length-1];
    	System.out.println(requestURI+ "   " + request.getContextPath());
    	System.out.println(command);
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(command.equals("boardInsertForm.do")){
    		action = new BoardInsertFormAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("boardInsertProc.do")){
    		action = new BoardInsertProcAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("boardList.do")){
    		action = new BoardListAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("boardDetailView.do")){
    		action = new BoardDetailViewAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("passwordForm.do")){
    		action = new BoardPasswoardFormAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("checkPassword.do")){
    		action = new BoardCheckPasswordProc();
    		forward = action.execute(request, response);
    	}else if(command.equals("deleteBoard.do")){ 
    		action = new BoardDeleteAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("boardModifyForm.do")){
    		action = new BoardModifyFormAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("boardModifyProc.do")){
    		action = new BoardModifyProcAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("ReplyInsertProc.do")){
    		action = new ReplyInsertProcAction();
    		forward = action.execute(request, response);
    	}else if(command.equals("error.do")){
    		action = new ErrorAction();
    		forward = action.execute(request, response);
    	}
    	
    	
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getUrl());
    		}else{
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher(forward.getUrl());
    			dispatcher.forward(request, response);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
