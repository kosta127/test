package kosta.dao;

import java.util.List;

import kosta.model.Board;
import kosta.model.BoardListModel;

public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao dao;
	
	public static BoardService getInstance(){
		dao = BoardDao.getInstance();
		return service;
	}
	
	public int insertBoard(Board board){	
		board.setB_id(dao.getMaxId()+1);
		return dao.insertBoard(board);		
	}
	
	public List<Board> listBoard(int pageNum){
		int startRow = (pageNum-1)*dao.LIST_SIZE;
		return dao.listBoard(startRow);
	}
	
	public Board detailView(int b_id){
		return dao.detailView(b_id);
	}
	
	public String getPassword(int b_id){
		return dao.getPassword(b_id);
	}
	
	public int deleteBoard(int b_id){
		return dao.deleteBoard(b_id);
	}
	
	public int updateBoard(Board board){
		return dao.updateBoard(board);
	}
	
	public BoardListModel getBoardListModel(int currentPage){
		int pageNumber = 5; //한페이지에 보여줄 페이지수
		int totCount = dao.getTotalCount();
		int totalPage = totCount/dao.LIST_SIZE + ((totCount%dao.LIST_SIZE>0)?1:0);
		int startPage = (currentPage<=pageNumber)?1:((currentPage/pageNumber)*pageNumber)+1;
		int endPage = (totalPage<(startPage+pageNumber)-1)?totalPage:(startPage+pageNumber)-1;
		return new BoardListModel(totalPage, startPage, endPage, currentPage,
						startPage>pageNumber, endPage<totalPage);
	}
	
	public int updateHit(int b_id){
		return dao.updateHit(b_id);
	}
}
