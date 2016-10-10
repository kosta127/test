package kosta.dao;

import java.util.List;

import kosta.model.Reply;

public class ReplyService {
	private static ReplyService service = new ReplyService();
	private static ReplyDao dao;
	
	public static ReplyService getInstance(){
		dao = ReplyDao.getInstance();
		return service;
	}
	
	public int insertReply(Reply reply){
		reply.setR_id(dao.getMaxId()+1);
		return dao.insertReply(reply);
	}
	
	public List<Reply> listReply(int b_id){
		return dao.listReply(b_id);
	}
	
	public String getPassword(int r_id){
		return dao.getPassword(r_id);
	}
	
	public int deleteReply(int r_id){
		return dao.deleteReply(r_id);
	}
}
