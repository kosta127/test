package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;
import kosta.model.Board;
import kosta.model.BoardListModel;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String strPageNum = request.getParameter("pageNum");
		int pageNum = (strPageNum!=null)?Integer.parseInt(strPageNum):1;
			
		BoardService service = BoardService.getInstance();
		List<Board> boardList = service.listBoard(pageNum);
		
		if(boardList != null){
			request.setAttribute("boardList", boardList);
			request.setAttribute("paging", service.getBoardListModel(pageNum));
			forward.setRedirect(false);
			forward.setUrl("/board/boardList.jsp");
		}else{
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}
		return forward;
	}
}
