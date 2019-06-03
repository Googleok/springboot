package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("email","thdnjs9570@naver.com");
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav; 
		
	}

	@RequestMapping("/hello3")
	public String hello3(Model model) { //이렇게 쓸수도 있다 이러면 modelandview 안해도 되고 string 리턴
										//통일성 있어서 더 선호하심(강사님은..)
		
		model.addAttribute("email", "rjsgud@naver.com");
		return "/WEB-INF/views/hello.jsp"; 
		
	}
	
	@RequestMapping("/hello4") //get post 분리 할수있음
	public String hello4(Model model,@RequestParam("email") String email, //외부에서 데이터 받아올때 정석으로 처리하는 것 
									@RequestParam String name ) { //관례로 된걸 생략 안하면 parameter 이름을 e로 바꿔서 바꿀수있음
		
		model.addAttribute("email",email);
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
		
	}
	
	
//	기술이 침투했기 때문에 비추천 
//	@RequestMapping("/hello5") 
//	public String hello5(Model model, HttpServletRequest request ) { // 이렇게 해도 됨 근데 쓰지 말긔 서블릿 기술이 침투된거니깐 
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		model.addAttribute("email",email);
//		System.out.println(name);
//		return "/WEB-INF/views/hello.jsp";
//		
//	}
	

}


