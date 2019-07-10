package com.cafe24.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.mysite.vo.ModalVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GuestbookVo> getList() {

		//List<GuestbookVo> result = new ArrayList<GuestbookVo>();

		List<GuestbookVo> result = sqlSession.selectList("guestbook.getList");
		return result;
	}

	public boolean insert(GuestbookVo vo) {

		int count = sqlSession.insert("guestbook.insert",vo);
		
		return 1 == count;

	}
	
	public boolean delete(GuestbookVo vo) {

		int count = sqlSession.delete("guestbook.delete",vo);
		
		return 1 == count;

	}

	public void modal(String email, String password, String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		map.put("contents", content);
		sqlSession.insert("modal.insert", map);
	}

	public List<ModalVo> getModalList() {
		List<ModalVo> result = sqlSession.selectList("modal.getList");
		System.out.println(result+"=================");
		return result;
	}
	

}
