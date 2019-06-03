package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

/*
 *  @RequestMapping 
 *  type + method
 */


@Controller
@RequestMapping("/user") //이걸 기본으로 하고 밑에꺼 +로 해서 url이 결정됨 더 편함
public class UserController {
	
	@RequestMapping(value= "/join", method=RequestMethod.GET) //기본값은 get,post둘다 됨
	//@GetMapping("/join") 위에랑 완전 동일
	public String join() {
		
		return "/WEB-INF/views/join.jsp";
	}

	
	@RequestMapping(value = {"/join" ,"/j"} , method=RequestMethod.POST) 
	//@PostMapping("/join","/j") 위에랑 완전 동일
	public String join(@ModelAttribute UserVo userVo) { //그냥 아예 UserVo를 받으면 됨!!! ModelAttribute 자동으로 model에다가 uservo 넣어줌
		if(valid(userVo) == false) {//valid 체크해서 에러나면 ? forwarding 해줌
			return "/WEB-INF/views/join.jsp";
		}
		System.out.println(userVo);
		//return "UserController:join(POST)"; //responsebody 덕분에 화면에 바로 출력 가능!!
		return "redirect:/hello";
	}
	
	private boolean valid(UserVo userVo) {
		return false;
	}
	
}



