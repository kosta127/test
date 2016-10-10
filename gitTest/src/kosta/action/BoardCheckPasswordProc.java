package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.BoardService;

public class BoardCheckPasswordProc implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		boolean isOk = false;
		int b_id = 0;
		String strBid = request.getParameter("b_id");
		System.out.println("BoardCheckPasswordProc b_id => " + strBid);
		if(strBid != null){
			BoardService service = BoardService.getInstance();
			b_id = Integer.parseInt(strBid);
			String orgPass = service.getPassword(b_id);
			String userPass = request.getParameter("b_password");
			isOk = orgPass.equals(userPass);
		}else{
			//아이디가 없으면 에러이므로 그냥 보내버림
			forward.setRedirect(true);
			forward.setUrl("error.do");
			return forward;
		}
		
		if(isOk){
			request.setAttribute("b_id", b_id);
			String flag = request.getParameter("flag");
			System.out.println("BoardCheckPasswordProc=>" + flag);
			forward.setRedirect(false);
			if(flag.equals("md")){
				forward.setUrl("boardModifyForm.do");
			}else{
				forward.setUrl("deleteBoard.do");
			}		
		}else{ //비밀번호가 틀림
			forward.setRedirect(false);
			forward.setUrl("/board/wrongPassword.jsp");
		}
		return forward;
	}

}
