package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberSystem{
	
	
	@RequestMapping("/Control/SingUpForm.do")
	public String singupform()throws Exception{
		return "/SingUP/SingUP.jsp";
	}
	
	@RequestMapping("/Control/SingUp.do")
	public String singup(@RequestParam String memberInfo,Map map )throws Exception{
		
		
		
		
		
		return "/Login/Login.jsp";
	}	
	
	
	
}
