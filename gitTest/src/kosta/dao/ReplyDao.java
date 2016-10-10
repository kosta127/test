package kosta.dao;

import java.io.InputStream;
import java.util.List;

import kosta.mapper.ReplyMapper;
import kosta.model.Reply;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyDao {
	private static ReplyDao dao = new ReplyDao();
	
	public static ReplyDao getInstance(){
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
			maxId = sqlSession.getMapper(ReplyMapper.class).getMaxId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return maxId;
	}
	public int insertReply(Reply reply){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(ReplyMapper.class).insertReply(reply);
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
	public List<Reply> listReply(int b_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reply> list = null;
		try {
			list = sqlSession.getMapper(ReplyMapper.class).listReply(b_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	public String getPassword(int r_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String password = null;
		try {
			password = sqlSession.getMapper(ReplyMapper.class).getPassword(r_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return password;
	}
	public int deleteReply(int r_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(ReplyMapper.class).deleteReply(r_id);
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
