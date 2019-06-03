package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 *  method 단독 매핑
 */


@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/write")
	public String write(@RequestParam(value="n",required=true ,defaultValue="") String name,
	@RequestParam(value="age",required=true ,defaultValue="0") int age)
	{
		if(age == 0) {
			System.out.println("나이를 입력해주세요");
		}
		System.out.println(name);
		System.out.println(age);
		return "BoardController:write()";
	}
	
	
	//이거는 파라미터 안붙이면 에러가 난다 그래서 default 값 정해지고 파라미터 넣으라고 알려주자
	@ResponseBody
	@RequestMapping("/board/update")
	public String update (@RequestParam("name") String name)//@RequestParam String name ,String name 
															//이거 세개 다 됨
	{	
		System.out.println("---"+name+"---");
		return "BoardController:update()";
	
	}
	
	///board/view?no=10 이거 보다는 /board/view/10 이렇게 하면 더 이쁨 (pretty url restful url)
	//그럼 어캐 하냐? 밑에
	@ResponseBody
	@RequestMapping("/board/view/{no}") 
	public String view(@PathVariable(value="no") Long no) {
		
		return "BoardController:view("+no+")";
	
	}
	
}
