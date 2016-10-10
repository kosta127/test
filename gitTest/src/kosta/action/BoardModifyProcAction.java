package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;
import kosta.model.Board;

public class BoardModifyProcAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();		
		Boolean errFlag = true;
		String strBid = request.getParameter("b_id");
		if(strBid != null){
			Board board = new Board();
			board.setB_id(Integer.parseInt(strBid));
			board.setB_name(request.getParameter("b_name"));
			board.setB_title(request.getParameter("b_title"));
			board.setB_contents(request.getParameter("b_contents"));
			
			BoardService service = BoardService.getInstance();
			int res = service.updateBoard(board);
			if(res>0){
				forward.setRedirect(false);
				forward.setUrl("boardDetailView.do?b_id="+strBid);
				errFlag = false;
			}
		}
		if(errFlag){
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}		
		return forward;
	}

}
