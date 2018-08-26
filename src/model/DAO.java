package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
	
	public PostDTO selectOnePost(PostDTO dto) {
		String sql = "SELECT * FROM POST WHERE NO=?";
		
		try {
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getNo());
			
			rs= psmt.executeQuery();
			
			while(rs.next()) {
				dto.setNo(rs.getString(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setPostdate(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setDowncount(rs.getString(6));
			}///while
			
		}
		
		catch (Exception e) {e.printStackTrace();}
		
		return dto;
	}
	
	
	//전체 레코드 수 얻기용- 페이징
	public int getTotalRecordCount() {
		int totalCount=0;
		String sql = "SELECT COUNT(*) FROM POST";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {e.printStackTrace();}
		return totalCount;
	}///////
	
	
	public List<PostDTO> selectList(Map map) {
		List<PostDTO> list = new Vector<PostDTO>();
		
		//페이징 적용 전 쿼리
		//String sql= "SELECT * FROM dataroom ORDER BY postdate DESC";
		//페이징 적용 쿼리
		String sql= "SELECT * FROM (SELECT T.*, ROWNUM R FROM (SELECT * FROM post ORDER BY postdate DESC) T) WHERE R BETWEEN ? AND ?";
		try {
			psmt=conn.prepareStatement(sql);
			//시작 및 끝 행번호 설정]
			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));
			rs= psmt.executeQuery();
			
			while(rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setNo(rs.getString("no"));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setPostdate(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setDowncount(rs.getString(6));
				
				list.add(dto);
				
			}///while
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}////////selectList()
	
	
	public int insertPost(PostDTO dto) {//글등록
		int affected=0;
		String sql = "INSERT INTO POST VALUES(SEQ_POST_NO.nextval,?,?,SYSDATE,?,?)";
		try {			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, 0);
			
			affected=psmt.executeUpdate();
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return affected;
	}////insert
	
	
	public int updatePost(PostDTO dto) {//글 수정
		int affected=0;
		String sql = "UPDATE POST SET TITLE=?, CONTENT=? WHERE NO=?";
		try {			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNo());
			
			affected=psmt.executeUpdate();
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return affected;
	}////insert
	
	
	
	
	public int delete(PostDTO dto) {//삭제
		int affected=0;
		String sql = "DELETE FROM POST WHERE NO=?";
		try {			
			psmt= conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getNo());
			
			affected=psmt.executeUpdate();
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return affected;
	}////insert


	public int memberUpdate(MemberDTO dto) {//회원수정용
		int affected=0;
		System.out.println("커리문 안에 들어옴");
		String sql = "UPDATE MEMBERS SET NAME=?, GENDER=?, TEL=?, LIFEAAGEPLAN=? WHERE ID=?";
		try {			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getLifeaAgePlan());
			psmt.setString(5, dto.getId());
			affected=psmt.executeUpdate();
		}		
		catch(SQLException e) {e.printStackTrace();}
		
		return affected;
	}
	
	public void updateDownloadCount(String no) {
		String sql="UPDATE POST SET downcount = downcount+1 WHERE no=?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, no);
			psmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
