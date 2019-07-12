package com.cafe24.mysite.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVo;

@RestController("guestbookAPIController")
@RequestMapping("/api/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="/list/{lastNo}", method=RequestMethod.GET)
	public JSONResult list(@PathVariable(value="lastNo") Long lastNo) {
		List<GuestbookVo> list = guestbookService.getList(lastNo);
		return JSONResult.success(list);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody GuestbookVo guestbookVo) {
		guestbookService.insert(guestbookVo);
		return JSONResult.success(guestbookVo);
	}
	
	@DeleteMapping("/{no}")
	public JSONResult delete(@PathVariable(value="no") Long no, @RequestParam(value="password") String password) {
		GuestbookVo guestbookVo = new GuestbookVo(no, password);
		System.out.println(guestbookVo);
		boolean result = guestbookService.delete(guestbookVo);
		System.out.println(result);
		return JSONResult.success(result ? guestbookVo.getNo() : -1);
	}
	
}