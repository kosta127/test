package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardPasswoardFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String strBid = request.getParameter("b_id");
		if(strBid!=null){
			request.setAttribute("b_id", Integer.parseInt(strBid));
			forward.setRedirect(false);
			forward.setUrl("/board/passwordForm.jsp");
		}else{
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}	
		
		return forward;
	}

}
