package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.mysite.repository.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.mysite.vo.ModalVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;

	public void getList(Model model) {

		List<GuestbookVo> list = guestbookDao.getList();
		model.addAttribute("list",list);
		
	}
	
	public List<GuestbookVo> getList(Long startNo) {

		return guestbookDao.getList(startNo);
	}

	public boolean insert(GuestbookVo guestbookVo) {
		
		return guestbookDao.insert(guestbookVo);
		
	}

	public boolean delete(GuestbookVo guestbookVo) {
		
		return guestbookDao.delete(guestbookVo);
	
	}

	public void modal(String email, String password, String content) {
		guestbookDao.modal(email, password, content);
	}

	public void modalList(Model model) {
		List<ModalVo> list = guestbookDao.getModalList();
		model.addAttribute("modalList", list);
	}
	
}
