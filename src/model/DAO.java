package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {

	public class DataRoomDAO {
		//멤버변수
		private Connection conn;
		private PreparedStatement psmt;
		private ResultSet rs;
		//톰캣이 만들어 놓은 커넷션을 커넥션 풀에서 가져다 쓰기]
		public DataRoomDAO(ServletContext context) {
			//데이타 베이스 연결하기-커넥션 풀 이용]
			try {
				Context ctx = new InitialContext();
				DataSource source=(DataSource)ctx.lookup(context.getInitParameter("JNDI_ROOT")+"/jdbc/spring");
				conn = source.getConnection();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
	
	
}
