package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setUrl(request.getContextPath()+"/board/errorPage.jsp");
		return forward;
	}

}
