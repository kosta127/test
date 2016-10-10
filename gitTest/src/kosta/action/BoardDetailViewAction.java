package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;
import kosta.dao.ReplyService;
import kosta.model.Board;
import kosta.model.Reply;

public class BoardDetailViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		Boolean isOk = false;
		String strBID = request.getParameter("b_id");		
		if(strBID!=null){
			//게시글
			int b_id = Integer.parseInt(strBID);
			BoardService service = BoardService.getInstance();
			int res = service.updateHit(b_id);
			if(res>0){
				Board board = service.detailView(b_id);
				
				//리플
				ReplyService rservice = ReplyService.getInstance();
				List<Reply> replyList = rservice.listReply(b_id);
				
				request.setAttribute("board", board);
				request.setAttribute("replyList", replyList);
				forward.setRedirect(false);
				forward.setUrl("/board/detailView.jsp");
				isOk = true;
			}			
		}

		if(!isOk){
			forward.setRedirect(false);
			forward.setUrl("error.do");
		}		
		return forward;
	}

}
