package kosta.mapper;

import java.util.List;

import kosta.model.Reply;

public interface ReplyMapper {
	public int getMaxId();
	public int insertReply(Reply reply);
	public List<Reply> listReply(int b_id);
	public String getPassword(int r_id);
	public int deleteReply(int r_id);
}
