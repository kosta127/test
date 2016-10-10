package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.ReplyService;
import kosta.model.Reply;

public class ReplyInsertProcAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		boolean isOk = false;
		String strBid = request.getParameter("b_id");
		if(strBid!=null){
			Reply reply = new Reply();
			reply.setR_password(request.getParameter("r_password"));
			reply.setR_name(request.getParameter("r_name"));
			reply.setR_contents(request.getParameter("r_contents"));
			reply.setB_id(Integer.parseInt(strBid));
			
			ReplyService service = ReplyService.getInstance();
			int res = service.insertReply(reply);
			if(res > 0){
				forward.setRedirect(false);
				forward.setUrl("boardDetailView.do?b_id="+strBid);
				isOk = true;
			}
		}

		if(!isOk){
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}
		
		return forward;
	}

}
