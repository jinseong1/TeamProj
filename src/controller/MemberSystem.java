package controller;

import java.sql.Connection;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.DAO;
import model.MemberDTO;

@Controller
public class MemberSystem{
	
	@RequestMapping("/Control/SingUpForm.do")
	public String singupform()throws Exception{//회원가입 눌렀을 시
		return "/SingUP/SingUP.jsp";
	}
	
	@RequestMapping("/Control/SingUp.do")
	public String singup(@RequestParam Map map)throws Exception{//회원가입 완료 눌렀을 시
		int affected;
		MemberDTO dto = new MemberDTO();
		
		dto.setId(map.get("UserID").toString());
		dto.setPassword(map.get("UserPWD").toString());
		dto.setName(map.get("UserNAME").toString());
		dto.setGender(map.get("gender").toString());
		dto.setTel(map.get("UserTEL").toString());
		dto.setLifeaAgePlan(map.get("UserlifeaAgePlan").toString());
		
		DAO dao = new DAO();
		
		affected = dao.insert(dto);
		
		System.out.println(affected);
		if(affected==1) {//회원가입 성공 시
			return "/Login/Login.jsp";
		}
		else {//회원가입 실패시
			return "/SingUP/SingUP.jsp";
		}
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
	
	
	//데이타 소스를 자동으로 주입 받기 위한(와이어링) 멤버변수(속성) 선언]
	@Resource(name="dataSourceByJDBC")
	private DataSource dataSourceJDBC;
	
	@Resource(name="dataSourceByJNDI")
	private DataSource dataSourceJNDI;
	
	
	
	@RequestMapping("/Control/JDBCConnection.do")
	public String jdbc(@RequestParam String method,Model model) throws Exception{
		//주입받은 DataSource객체로 Connection객체 얻기]
		Connection conn=dataSourceJDBC.getConnection();
		//데이타 저장]
		model.addAttribute("message",conn==null ? "[데이타베이스 연결 실패]" : "[데이타베이스 연결 성공]" );
		//커넥션 객체 메모리 해제
		if(conn !=null) conn.close();
		//뷰정보 반환]
		return "/Database08/Database.jsp";
	}/////////////
	
	@RequestMapping("/Control/JNDIConnection.do")
	public String jndi(@RequestParam String method,Model model) throws Exception{
		//주입받은 DataSource객체로 Connection객체 얻기]
		Connection conn=dataSourceJNDI.getConnection();
		//데이타 저장]
		model.addAttribute("message",conn==null ? "[데이타베이스 연결 실패]" : "[데이타베이스 연결 성공]" );
		//커넥션  풀에 커넥션객체 반납
		if(conn !=null) conn.close();
		//뷰정보 반환]
		return "/Database08/Database.jsp";
	}/////////////
	
}
