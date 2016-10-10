package kosta.dao;

import java.io.InputStream;
import java.util.List;

import kosta.mapper.BoardMapper;
import kosta.model.Board;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao{
	private static BoardDao dao = new BoardDao();
	public final int LIST_SIZE = 5;
	
	public static BoardDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new SqlSessionFactoryBuilder().build(input);
	}	
	
	public int getMaxId(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int maxId = 0;
		try {
			maxId = sqlSession.getMapper(BoardMapper.class).getMaxId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return maxId;
	}
	
	public int insertBoard(Board board){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			if(res>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}
	
	public List<Board> listBoard(int startRow){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Board> list = null;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(
					new RowBounds(startRow, LIST_SIZE));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public Board detailView(int b_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Board board = null;
		try {
			board = sqlSession.getMapper(BoardMapper.class).detailView(b_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return board;
	}
	
	public String getPassword(int b_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String pass = null;
		try {
			pass = sqlSession.getMapper(BoardMapper.class).getPassword(b_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return pass;
	}
	
	public int deleteBoard(int b_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(BoardMapper.class).deleteBoard(b_id);
			if(res>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}
	
	public int updateBoard(Board board){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
			if(res>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}
	
	public int getTotalCount(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int totalCount = 0;
		try {
			totalCount = sqlSession.getMapper(BoardMapper.class).getTotalCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return totalCount;
	}
	
	public int updateHit(int b_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(BoardMapper.class).updateHit(b_id);
			if(res>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}
}
