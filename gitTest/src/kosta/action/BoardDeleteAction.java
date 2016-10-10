package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int b_id = (int) request.getAttribute("b_id");
		System.out.println(b_id);
		BoardService service = BoardService.getInstance();
		int res = service.deleteBoard(b_id);
		if(res>0){
			forward.setRedirect(true);
			forward.setUrl(request.getContextPath()+"/board/deleteComplete.jsp");
		}else{
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}
		
		return forward;
	}

}
