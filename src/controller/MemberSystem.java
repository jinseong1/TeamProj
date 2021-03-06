package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.DAO;
import model.MemberDTO;
import model.PagingUtil;
import model.PostDTO;

@SessionAttributes("userID")
@Controller
public class MemberSystem{
	List<PostDTO> list =null;
	
	@Resource(name="dataSourceByJNDI")
	private DataSource dataSourceJNDI;
	
	@RequestMapping("/Control/FirstPage.do")
	public String loginpage1()throws Exception{//첫페이지 이동
		System.out.println("여기로 들어옴");
		return "/WEB-INF/Login/Login.jsp";
	}	
	
	@RequestMapping("/Control/SingUpForm.do")
	public String singupform()throws Exception{//회원가입 눌렀을 시
		return "/WEB-INF/SingUP/SingUP.jsp";
	}
	
	@RequestMapping("/Control/SingUp.do")
	public String singup(@RequestParam Map map, Model model)throws Exception{//회원가입 완료 눌렀을 시
		int affected;
		MemberDTO dto = new MemberDTO();
		
		if(map.get("UserID").toString().trim().equals("")) {
			model.addAttribute("errorMessage", "아이디 입력칸이 비어있습니다");
			return "/WEB-INF/SingUP/SingUP.jsp";			
		}
		else if(map.get("UserPWD").toString().trim().equals("")){
			model.addAttribute("errorMessage", "비밀번호 입력칸이 비어있습니다");
			return "/WEB-INF/SingUP/SingUP.jsp";			
		}
		else if(map.get("UserNAME").toString().trim().equals("")){
			model.addAttribute("errorMessage", "이름 입력칸이 비어있습니다");
			return "/WEB-INF/SingUP/SingUP.jsp";			
		}
		else if(map.get("gender")==null){
			model.addAttribute("errorMessage", "성별이 선택되지 않았습니다");
			return "/WEB-INF/SingUP/SingUP.jsp";			
		}
		else if(map.get("UserTEL").toString().trim().equals("")){
			model.addAttribute("errorMessage", "전화번호 입력칸이 비어있습니다");
			return "/WEB-INF/SingUP/SingUP.jsp";			
		}
		
		
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
			return "/WEB-INF/Login/Login.jsp";
		}
		else {//회원가입 실패시
			model.addAttribute("errorMessage", "일치하는 아이디가 있습니다");			
			return "/WEB-INF/SingUP/SingUP.jsp";
		}
	}	
	
	
	@RequestMapping("/Control/MainMove.do")
	public String mainMove(@RequestParam Map map, HttpSession session, Model model)throws Exception{//로그인 눌렀을 시
		int affected;
		MemberDTO dto = new MemberDTO();
		
		if(map.get("userID").toString().trim().equals("")) {
			System.out.println("아이디가 비어져있음");
			model.addAttribute("errorMessage","아이디가 비어있습니다");
			return "/WEB-INF/Login/Login.jsp";
		}
		else if(map.get("userPWD").toString().trim().equals("")) {
			System.out.println("비밀번호가 비어져있음");
			model.addAttribute("errorMessage","비밀번호가 비어있습니다");
			return "/WEB-INF/Login/Login.jsp";
		}		
		
		
		
		dto.setId(map.get("userID").toString());
		session.setAttribute("userID", map.get("userID").toString());
		dto.setPassword(map.get("userPWD").toString());
		
		DAO dao = new DAO(dataSourceJNDI);
		
		affected=dao.selectOne(dto);
		
		dao.close();
		
		if(affected==1) {//로그인 성공
			
			return "/WEB-INF/InSite/Main.jsp";
			
		}
		else {//로그인 실패
			model.addAttribute("errorMessage","아이디나 비밀번호가 일치하지 않습니다.");
			return "/WEB-INF/Login/Login.jsp";
			
		}
	}
	
	
	@RequestMapping("/Control/Main.do")
	public String main()throws Exception{//Main화면으로 이동
			return "/WEB-INF/InSite/Main.jsp";
	}
	
	
	@RequestMapping("/Control/Logout.do")
	public String logout(SessionStatus status)throws Exception{//로그아웃 클릭시
		
		status.setComplete();
		
		return "/WEB-INF/Login/Login.jsp";
	}
	

	
	
	@RequestMapping("/Control/NoticeBoard.do")
	public String noticeBoard(@RequestParam int nowPage,Map map, HttpServletRequest req, @ModelAttribute("userID")String id)throws Exception{//게시판으로 이동
		Map rownum = new HashMap();
		map.put("id", id);
		DAO dao = new DAO(dataSourceJNDI);
		//전체 레코드 수
		int totalRecordCount = dao.getTotalRecordCount();
		//페이지 사이즈
		int pageSize = 10;
		//블락 페이지
		int blockPage = 3;
		//전체페이지 수
		int totalPage = (int)Math.ceil(((double)totalRecordCount/pageSize));
		
		
		String pagingString = PagingUtil.pagingBootStrapStyle(
				totalRecordCount, 
				pageSize, 
				blockPage, 
				nowPage, 
				req.getContextPath()+"/Control/NoticeBoard.do?");
		
		map.put("pagingString", pagingString);
		map.put("totalRecordCount", totalRecordCount);
		map.put("nowPage", nowPage);
		map.put("pageSize", pageSize);
		
		//시작 및 끝 rownum구하기]
		int start =(nowPage-1)*pageSize+1;
		int end = nowPage*pageSize;
		
		rownum.put("start", start);
		rownum.put("end", end);

		list = dao.selectList(rownum);
		dao.close();

		
		map.put("list", list);
		
		
		return "/WEB-INF/InSite/NoticeBoard.jsp?nowPage="+nowPage;
	}

	
	@RequestMapping("/Control/Write.do")
	public String write(HttpSession session, Map map)throws Exception{//Write화면으로 이동
		
		map.put("userID", session.getAttribute("userID"));
		
		return "/WEB-INF/InSite/Write.jsp";
	}
	
	
	@RequestMapping("/Control/WriteEnd.do")
	public String writeEnd(@RequestParam Map map, HttpSession session,Model model)throws Exception{//글등록 완료용
		
		int affected;
		
		DAO dao = new DAO(dataSourceJNDI);
		
		PostDTO dto = new PostDTO();
		
		if(map.get("title").toString().trim().equals("")) {
			model.addAttribute("errorMessage","제목칸이 비어져있습니다");
			return "/WEB-INF/InSite/Write.jsp";
		}
		else if(map.get("content").toString().trim().equals("")) {
			model.addAttribute("errorMessage","내용칸이 비어져있습니다");
			return "/WEB-INF/InSite/Write.jsp";
		}		
		
		
		dto.setId(session.getAttribute("userID").toString());
		
		dto.setTitle(map.get("title").toString());
		
		dto.setContent(map.get("content").toString());
		
		affected=dao.insertPost(dto);
		
		dao.close();
		
		if(affected==1) {//입력 성공시
			return "/Control/NoticeBoard.do?nowPage=1";
		}
		else {//입력 실패시
			model.addAttribute("errorMessage","글 등록이 실패되었습니다");			
			return "/WEB-INF/InSite/Write.jsp";
		}
	}
	
	@RequestMapping("/Control/ViewMove.do")
	public String viewMove(@RequestParam Map map, Model model)throws Exception{//상세보기 이동용
		
		String no = map.get("no").toString();
		String nowPage = map.get("nowPage").toString();		
		
		DAO dao = new DAO(dataSourceJNDI);
		
		PostDTO dto = new PostDTO();
		
		dto.setNo(no);
		dao.updateDownloadCount(no);
		dto=dao.selectOnePost(dto);
		
		model.addAttribute("list",dto);
		model.addAttribute("nowPage", nowPage);
		
		dao.close();
		
			return "/WEB-INF/InSite/View.jsp?no="+no;
	}
	
	@RequestMapping("/Control/Delete.do")
	public String delete(@RequestParam Map map, HttpSession session)throws Exception{//삭제용
		
		int affected;
		
		DAO dao = new DAO(dataSourceJNDI);
		
		PostDTO dto = new PostDTO();
		
		String no = map.get("no").toString();
		
		System.out.println(no);
		
		dto.setNo(no);
		
		affected=dao.delete(dto);
		
		dao.close();
		
		if(affected==1) {//삭제 성공시
			return "/Control/NoticeBoard.do?nowPage=1";
		}
		else {//삭제 실패시
			return "/WEB-INF/InSite/View.jsp?no="+no;
		}
	}
	
	
	@RequestMapping("/Control/UpdateMove.do")
	public String updateMove(@RequestParam Map map, Model model)throws Exception{//수정페이지로 이동
		
		model.addAllAttributes(map);
		
		return "/WEB-INF/InSite/Update.jsp";
	}
	
	
	
	@RequestMapping("/Control/Update.do")
	public String update(@RequestParam Map map,Model model)throws Exception{//글 수정용
		
		int affected;
		
		if(map.get("title").toString().trim().equals("")) {
			model.addAttribute("errorMessage","제목칸이 비어져있습니다");
			return "/WEB-INF/InSite/Write.jsp";
		}
		else if(map.get("content").toString().trim().equals("")) {
			model.addAttribute("errorMessage","내용칸이 비어져있습니다");
			return "/WEB-INF/InSite/Write.jsp";
		}		
		
		
		
		String nowPage = map.get("nowPage").toString();
		DAO dao = new DAO(dataSourceJNDI);
		
		PostDTO dto = new PostDTO();
		
		dto.setNo(map.get("no").toString());
		
		dto.setTitle(map.get("title").toString());
		
		dto.setContent(map.get("content").toString());
		
		affected=dao.updatePost(dto);
		
		dao.close();
		
		if(affected==1) {//입력 성공시
			return "/Control/ViewMove.do?nowPage="+nowPage;
		}
		else {//입력 실패시
			return "/WEB-INF/InSite/Write.jsp";
		}
	}	
	
	@RequestMapping("/Control/MyPage.do")
	public String myPageMove()throws Exception{//MyPage로 이동
		
		return "/WEB-INF/InSite/MyPage.jsp";
	}
	
	
	
	@RequestMapping("/Control/MemberUpdate.do")
	public String memberUpdate(@RequestParam Map map,Model model)throws Exception{//회원정보 수정
		int affected;
		
		if(map.get("name").toString().trim().equals("")) {
			model.addAttribute("errorMessage", "이름 칸이 비어져있습니다");
			return"/WEB-INF/InSite/MyPage.jsp";
			
		}
		else if(map.get("gender").toString().trim().equals("")) {
			model.addAttribute("errorMessage", "성별이 선택되어 있지 않습니다");			
			return"/WEB-INF/InSite/MyPage.jsp";
			
		}		
		else if(map.get("tel").toString().trim().equals("")) {
			model.addAttribute("errorMessage", "전화번호 칸이 비어져있습니다");			
			return"/WEB-INF/InSite/MyPage.jsp";
		}		
		
		
		DAO dao = new DAO(dataSourceJNDI);
		
		MemberDTO dto = new MemberDTO();
		System.out.println("id"+map.get("id").toString());
		System.out.println("name"+map.get("name").toString());
		System.out.println("gender"+map.get("gender").toString());
		System.out.println("tel"+map.get("tel").toString());
		System.out.println("생년월일"+map.get("userlifeaAgePlan").toString());
		
		
		dto.setId(map.get("id").toString());
		dto.setName(map.get("name").toString());
		dto.setGender(map.get("gender").toString());
		dto.setTel(map.get("tel").toString());
		dto.setLifeaAgePlan(map.get("userlifeaAgePlan").toString());
		
		System.out.println("수정 커리문 후");
		affected=dao.memberUpdate(dto);
		System.out.println("affected"+affected);
		System.out.println("수정 커리 문 다음");
		dao.close();
		if(affected==1) {
			System.out.println("수정 성공");
			return"/WEB-INF/Login/Login.jsp";
		}
		else {
			System.out.println("수정 실패");
			model.addAttribute("errorMessage", "수정이 실패되었습니다");	
			return"/WEB-INF/InSite/MyPage.jsp";
		}
	}
	
	
	
	
	
	
}
