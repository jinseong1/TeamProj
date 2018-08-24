package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberSystem{
	
	
	@RequestMapping("/Control/SingUpForm.do")
	public String singupform()throws Exception{//회원가입 눌렀을 시
		return "/SingUP/SingUP.jsp";
	}
	
	@RequestMapping("/Control/SingUp.do")
	public String singup(@RequestParam String memberInfo,Map map )throws Exception{//회원가입 완료 눌렀을 시
		
		
		return "/Login/Login.jsp";
	}	
	
	
	@RequestMapping("/Control/MainMove.do")
	public String mainMove()throws Exception{//Main화면으로 이동
		return "/InSite/Main.jsp";
	}
	
	@RequestMapping("/Control/Logout.do")
	public String logout()throws Exception{//로그아웃 클릭시
		
		
		return "/Login/Login.jsp";
	}
	
	@RequestMapping("/Control/NoticeBoard.do")
	public String noticeBoard()throws Exception{
		
		return "/InSite/NoticeBoard.jsp";
	}
	
	
}
