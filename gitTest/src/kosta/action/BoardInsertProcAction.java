package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;
import kosta.model.Board;

public class BoardInsertProcAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		Board b = new Board();		
		b.setB_password(request.getParameter("b_password"));
		b.setB_name(request.getParameter("b_name"));
		b.setB_title(request.getParameter("b_title"));
		b.setB_contents(request.getParameter("b_contents"));
		
		BoardService service = BoardService.getInstance();		
		int res = service.insertBoard(b);
		
		if(res>0){
			forward.setRedirect(false);
			forward.setUrl("boardList.do");
		}else{
			forward.setRedirect(false);
			forward.setUrl("error.do");
		}
		return forward;
	}

}
