package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;
import kosta.model.Board;

public class BoardModifyFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int b_id = (int)request.getAttribute("b_id");
		BoardService service = BoardService.getInstance();
		Board board = service.detailView(b_id);
		if(board != null){
			request.setAttribute("board", board);
			forward.setRedirect(false);
			forward.setUrl("/board/modifyForm.jsp");
		}else{
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}
		
		return forward;
	}

}
