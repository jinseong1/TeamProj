package controller.database;


import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DatabaseController {
	//데이타 소스를 자동으로 주입 받기 위한(와이어링) 멤버변수(속성) 선언]
	@Resource(name="dataSourceByJDBC")
	private DataSource dataSourceJDBC;
	
	@Resource(name="dataSourceByJNDI")
	private DataSource dataSourceJNDI;
	
	
	
	@RequestMapping("/Database/JDBCConnection.do")
	public String jdbc(@RequestParam String method,Model model) throws Exception{
		System.out.println(dataSourceJNDI);
		//주입받은 DataSource객체로 Connection객체 얻기]
		Connection conn=dataSourceJDBC.getConnection();
		System.out.println(conn);
		//데이타 저장]
		model.addAttribute("message",conn==null ? "[데이타베이스 연결 실패]" : "[데이타베이스 연결 성공]" );
		//커넥션 객체 메모리 해제
		if(conn !=null) conn.close();
		//뷰정보 반환]
		return "/Database08/Database.jsp";
	}/////////////
	
	@RequestMapping("/Database/JNDIConnection.do")
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
