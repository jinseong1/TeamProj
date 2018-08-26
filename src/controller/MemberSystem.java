package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.DAO;
import model.MemberDTO;
import model.PostDTO;

@Controller
public class MemberSystem{
	List<PostDTO> list =null;
	
	@Resource(name="dataSourceByJNDI")
	private DataSource dataSourceJNDI;
	
	
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
		
		DAO dao = new DAO(dataSourceJNDI);
		
		affected = dao.insert(dto);
		
		dao.close();
		
		if(affected==1) {//회원가입 성공 시
			return "/Login/Login.jsp";
		}
		else {//회원가입 실패시
			return "/SingUP/SingUP.jsp";
		}
	}	
	
	
	@RequestMapping("/Control/MainMove.do")
	public String mainMove(@RequestParam Map map, HttpSession session)throws Exception{//로그인 눌렀을 시
		int affected;
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId(map.get("userID").toString());
		session.setAttribute("userID", map.get("userID").toString());
		dto.setPassword(map.get("userPWD").toString());
		
		DAO dao = new DAO(dataSourceJNDI);
		
		affected=dao.selectOne(dto);
		
		dao.close();
		
		if(affected==1) {//로그인 성공
			
			return "/InSite/Main.jsp";
			
		}
		else {//로그인 실패
			
			return "/Login/Login.jsp";
			
		}
	}
	
	
	@RequestMapping("/Control/Main.do")
	public String main()throws Exception{//Main화면으로 이동
			return "/InSite/Main.jsp";
	}
	
	
	@RequestMapping("/Control/Logout.do")
	public String logout(SessionStatus status)throws Exception{//로그아웃 클릭시
		
		status.setComplete();
		
		return "/Login/Login.jsp";
	}
	

	
	
	@RequestMapping("/Control/NoticeBoard.do")
	public String noticeBoard(@RequestParam int nowPage,Map map)throws Exception{//게시판으로 이동
		Map rownum = new HashMap();
		DAO dao = new DAO(dataSourceJNDI);
		//전체 레코드 수
		int totalRecordCount = dao.getTotalRecordCount();
		//페이지 사이즈
		int pageSize =5;
		//블락 페이지
		int blockPage = 3;
		//전체페이지 수
		int totalPage = (int)Math.ceil(((double)totalRecordCount/pageSize));
		

		//시작 및 끝 rownum구하기]
		int start =(nowPage-1)*pageSize+1;
		int end = nowPage*pageSize;
		
		rownum.put("start", start);
		rownum.put("end", end);

		list = dao.selectList(rownum);
		dao.close();

		
		map.put("list", list);
		
		
		return "/InSite/NoticeBoard.jsp";
	}

	
	@RequestMapping("/Control/Write.do")
	public String write(HttpSession session, Map map)throws Exception{//Write화면으로 이동
		
		map.put("userID", session.getAttribute("userID"));
		
		return "/InSite/Write.jsp";
	}
	
	
	@RequestMapping("/Control/WriteEnd.do")
	public String writeEnd(@RequestParam Map map, HttpSession session)throws Exception{
		
		int affected;
		
		DAO dao = new DAO(dataSourceJNDI);
		
		PostDTO dto = new PostDTO();
		
		dto.setId(session.getId());
		
		dto.setTitle(map.get("title").toString());
		
		dto.setContent(map.get("content").toString());
		
		affected=dao.insertPost(dto);
		
		dao.close();
		
		if(affected==1) {
			return "/InSite/NoticeBorad.jsp";
		}
		else {
			return "/InSite/Write.jsp";
		}
	}
	
	
	
}
