package kosta.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.model.Board;

public interface BoardMapper {
	public int getMaxId();
	public int insertBoard(Board board);
	public List<Board> listBoard(RowBounds rb);
	public Board detailView(int b_id);
	public String getPassword(int b_id);
	public int deleteBoard(int b_id);
	public int updateBoard(Board board);
	public int getTotalCount();
	public int updateHit(int b_id);
}
