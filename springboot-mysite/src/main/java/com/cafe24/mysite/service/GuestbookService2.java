package com.cafe24.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.mysite.repository.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;

@Service
public class GuestbookService2 {
	
	@Autowired
	private GuestbookDao guestbookDao;

	public void getList(Model model) {

		List<GuestbookVo> list = guestbookDao.getList();
		model.addAttribute("list",list);
		
	}
	
	public List<GuestbookVo> getList(Long lastNo) {

		List<GuestbookVo> list = guestbookDao.getList(lastNo);
		return list;
	}
	
	public boolean insert(GuestbookVo guestbookVo) {
		
		return guestbookDao.insert(guestbookVo);
		
	}

	public boolean delete(GuestbookVo guestbookVo) {
		
		return guestbookDao.delete(guestbookVo);
	
	}

	public GuestbookVo addContents(GuestbookVo guestbookVo) {
		guestbookVo.setNo(10L);
		guestbookVo.setRegdate("2019-07-10 00:00:00");
		return guestbookVo;
	}

	public Long deleteContents(Long no, String  password) {
		return no;
	}

}