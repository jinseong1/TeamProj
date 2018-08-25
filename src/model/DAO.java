package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.bind.annotation.RequestMapping;

public class DAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	//톰캣이 만들어 놓은 커넷션을 커넥션 풀에서 가져다 쓰기]
	public DAO(DataSource dataSourceJNDI) {
		//주입받은 DataSource객체로 Connection객체 얻기]
		try {
			conn = dataSourceJNDI.getConnection();
			System.out.println("연결 성공");
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}//////////////




	//자원 반납용]-사용한 커넥션 개체를 다시 풀에 반납
	public void close() {
		try {
			//메모리 해제
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			//커넥션 풀에 커넥션 객체 반납 - 메모리 해제 아님
			if(conn!= null) conn.close();
		} catch (SQLException e) {e.printStackTrace();}
	}////////close()
	
	public int insert(MemberDTO dto) {//회원가입
		int affected=0;
		String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?)";
		try {			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getGender());
			psmt.setString(5, dto.getTel());
			psmt.setString(6, dto.getLifeaAgePlan());
			
			affected=psmt.executeUpdate();
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return affected;
	}////insert
	
	public int selectOne(MemberDTO dto) {
		int affected=0;
		String sql = "SELECT * FROM MEMBERS WHERE ID=? AND PASSWORD=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());
			affected=psmt.executeUpdate();
		}
		catch (Exception e) {e.printStackTrace();}
		
		return affected;
	}
	
}
