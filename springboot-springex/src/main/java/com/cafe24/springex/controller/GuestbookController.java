package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 *  type 단독 : method 이름을 url로 쓸수있게
 *  이거는 쓰지 말기
 */


@RequestMapping("/guestbook/*")
@Controller
public class GuestbookController {

	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController:list";
	}
	
}
